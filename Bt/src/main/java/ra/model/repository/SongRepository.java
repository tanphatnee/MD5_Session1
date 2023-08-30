package ra.model.repository;

import ra.model.entity.Song;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository implements ISongRepository {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.config.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Song> findAll() {
        List<Song> list = new ArrayList<>();
        // select * from Person (object)
        String query = "select p from Song as p";
        // sử dụng các phương thức get/set của đối tượng 1 cách tự động
        TypedQuery<Song> typedQuery = entityManager.createQuery(query,Song.class);
        list= typedQuery.getResultList();
        return list;
    }

    @Override
    public Song findById(Long id) {
        // sử dụng phương thức của đối tượng 1 cách tự động
        TypedQuery<Song> typedQuery = entityManager.createQuery("select s from Song as s where s.id =:id",Song.class);
        typedQuery.setParameter("id",id);
        // lấy về 1 đối tượng
        Song s = typedQuery.getSingleResult();
        return s;
    }

    @Override
    public void save(Song song) {
        // khởi tạo các đối tượng để quản lý giao dịch
        Session session = null;
        Transaction transaction = null;
        try {
            // khởi tạo phiên
            session = sessionFactory.openSession();
            // bắt đầu 1 giao dịch
            transaction = session.beginTransaction();
            if(song.getId()==null){
                // chức năng thêm mới
                session.save(song);
            } else {
                Song old = findById(song.getId());
                if(song.getUrl()==null){
                    song.setUrl(old.getUrl());
                }
                old.copy(song);
                session.saveOrUpdate(old);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.isActive();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    @Override
    public void delete(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(findById(id));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {transaction.isActive();}
        } finally {
            if (session != null) {session.close();}
        }
    }
}