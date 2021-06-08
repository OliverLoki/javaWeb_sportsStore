package smbms.services.goods;

import smbms.dao.BaseDao;
import smbms.dao.goods.GoodsDao;
import smbms.dao.goods.GoodsDaoImpl;
import smbms.pojo.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class GoodsServicesImpl implements GoodsServices {
    GoodsDao goodsDao = new GoodsDaoImpl();

    @Override
    public List<Goods> getAllGoods() {
        List<Goods> allGoods = new ArrayList<>();
        Connection connection = BaseDao.getConnection();
        if (null != connection) {
            try {
                allGoods = goodsDao.getAllGoods(connection);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(connection, null, null);
            }
        }
        return allGoods;
    }

    @Override
    public List<Goods> getGoods(int listId) {
        List<Goods> allGoods = new ArrayList<>();
        Connection connection = BaseDao.getConnection();
        if (null != connection) {
            try {
                allGoods = goodsDao.getGoods(connection,listId);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(connection, null, null);
            }
        }
        return allGoods;
    }

    @Override
    public Goods getGoodsByGid(int gid) {
        Connection connection = BaseDao.getConnection();
        Goods goods =null;
        if(null!=connection){
            goods = new Goods();
            try {
                goods=goodsDao.getGoodsBygid(connection,gid);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(connection, null, null);
            }
        }
        return goods;
    }

    @Override
    public List<Goods> getGoodsByName(String name) {
        List<Goods> goods = new ArrayList<>();
        Connection connection = BaseDao.getConnection();
        if(null!=connection){
            try {
                goods = goodsDao.getGoodsByName(connection,name);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                BaseDao.closeResource(connection, null, null);
            }
        }
        return goods;
    }

    @Override
    public int insertgoods(int Gid, int Uid) {
        int updateRows = 0;
        Connection connection = BaseDao.getConnection();
        if(null!=connection){
            try {
                updateRows  = goodsDao.insertGoods(connection, Gid, Uid);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                BaseDao.closeResource(connection, null, null);
            }
        }
        return  updateRows;
    }

    @Override
    public List<Goods> getCartGoods(int uid) {
        List<Goods> goods = new ArrayList<>();
        Connection connection = BaseDao.getConnection();
        if(null!=connection){
            try {
                goods = goodsDao.getCartGoods(connection, uid);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                BaseDao.closeResource(connection, null, null);
            }
        }
        return goods;
    }
}
