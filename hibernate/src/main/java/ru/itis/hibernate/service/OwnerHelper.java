package ru.itis.hibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.itis.hibernate.model.Owner;
import ru.itis.hibernate.util.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OwnerHelper {
    private SessionFactory sessionFactory;

    public OwnerHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Owner> getOwnerList() {
        // Подготовка запроса
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Owner.class);
        Root<Owner> root = criteriaQuery.from(Owner.class);

        criteriaQuery.select(root);

        // Запрос
        Query query = session.createQuery(criteriaQuery);
        List<Owner> ownerList = query.getResultList();
        for (Owner owner: ownerList) {
            System.out.println(owner.getId() + " " + owner.getName());
        }
        session.close();
        return ownerList;
    }
}
