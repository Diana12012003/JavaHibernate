package Homework6.task1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Word.class);

        try(SessionFactory factory = configuration.buildSessionFactory()) {
            Session session = factory.openSession();

            session.beginTransaction();

            session.persist(new Word("Java"));
            session.persist(new Word("HTML"));
            session.persist(new Word("TypeScript"));
            session.persist(new Word("QA Manual"));

            session.getTransaction().commit();

            List<Word> allWords = session.createQuery("from Word", Word.class).list();

            List<String> resultList = allWords.stream()
                    .map(Word::getValue)
                    .collect(Collectors.toList());
            System.out.println(resultList);
        }

    }

}
