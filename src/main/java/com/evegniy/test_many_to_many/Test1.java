package com.evegniy.test_many_to_many;

import com.evegniy.test_many_to_many.entity.Children;
import com.evegniy.test_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Children.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {

            //save
            /*Section section1 = Section.builder()
                    .name("Football")
                    .build();
            Children children1 = Children.builder()
                    .name("Evgeniy")
                    .age(7)
                    .build();
            Children children2 = Children.builder()
                    .name("Nina")
                    .age(5)
                    .build();
            Children children3 = Children.builder()
                    .name("Katya")
                    .age(4)
                    .build();
            section1.addChildToSection(children1);
            section1.addChildToSection(children2);
            section1.addChildToSection(children3);

            session.beginTransaction();

            session.save(section1);

            session.getTransaction().commit();*/

            //get
            /*session.beginTransaction();

            Section section = session.get(Section.class, 1L);
            System.out.println(section);
            System.out.println(section.getChildrenList());

            session.getTransaction().commit();*/

            //delete
            /*session.beginTransaction();

            Section section = session.get(Section.class, 1L);
            session.delete(section);

            session.getTransaction().commit();*/

            //save if u don't use cascadeType.all
            Section section1 = Section.builder()
                    .name("Dance")
                    .build();
            Children children1 = Children.builder()
                    .name("Evgeniy")
                    .age(7)
                    .build();
            Children children2 = Children.builder()
                    .name("Nina")
                    .age(5)
                    .build();
            Children children3 = Children.builder()
                    .name("Katya")
                    .age(4)
                    .build();
            section1.addChildToSection(children1);
            section1.addChildToSection(children2);
            section1.addChildToSection(children3);

            session.beginTransaction();

            session.persist(section1);

            session.getTransaction().commit();


        } finally {
            sessionFactory.close();
        }
    }
}
