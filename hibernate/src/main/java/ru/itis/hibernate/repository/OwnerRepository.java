package ru.itis.hibernate.repository;

import org.hibernate.query.Query;
import org.hibernate.Session;
import ru.itis.hibernate.model.Owner;
import ru.itis.hibernate.util.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class OwnerRepository implements CrudRepository<Owner, Long> {

    @Override
    public Optional<Owner> findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        Owner owner = session.get(Owner.class, id);

        return Optional.of(owner);
    }

    @Override
    public List<Owner> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("from Owner");
        List<Owner> list = query.list();

        session.getTransaction().commit();
        session.close();

        return list;
    }

    @Override
    public void save(Owner item) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        session.save(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        Owner owner = session.get(Owner.class, id);
        session.delete(owner);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Long id, Owner item) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        session.get(Owner.class, id).setName(item.getName());

        session.getTransaction().commit();
        session.close();
    }

}
