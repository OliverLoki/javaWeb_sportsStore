package smbms.dao.goods;

import smbms.dao.BaseDao;
import smbms.pojo.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    /**
     * @return
     */
    @Override
    public List<Goods> getAllGoods(Connection connection) throws Exception {
        List<Goods> goodsList = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from goods";
        Object[] param = {};
        Goods goods = null;
        if (null != connection) {//避免空指针异常
            rs = BaseDao.execute(connection, pstm, rs, sql, param);
            while (rs.next()) {
                goods = new Goods();
                goods.setGid(rs.getInt("Gid"));
                goods.setGname(rs.getString("Gname"));
                goods.setGprice(rs.getString("Gprice"));
                goods.setGurl(rs.getString("Gurl"));
                goods.setGlist_id(rs.getInt("Glist_id"));
                goodsList.add(goods);
            }
        }
        return goodsList;
    }

    @Override
    public List<Goods> getGoods(Connection connection, int listId) throws Exception {
        String sql = "select * from goods where Glist_id=?";
        List<Goods> goodsList = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Object[] param = {listId};
        Goods goods = null;
        if (null != connection) {//避免空指针异常
            rs = BaseDao.execute(connection, pstm, rs, sql, param);
            while (rs.next()) {
                goods = new Goods();
                goods.setGid(rs.getInt("Gid"));
                goods.setGname(rs.getString("Gname"));
                goods.setGprice(rs.getString("Gprice"));
                goods.setGurl(rs.getString("Gurl"));
                goods.setGlist_id(rs.getInt("Glist_id"));
                goodsList.add(goods);
            }
        }
        return goodsList;
    }

    @Override
    public List<Goods> getGoodsByName(Connection connection, String name) throws Exception {
        List<Goods> goodsList = new ArrayList<>();
        //TODO:jdbc对于模糊查询like语句嵌套变量的sql语句写法
        String sql = "select * from goods where gdesc like ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        //TODO:解决方案
        pstm.setObject(1,"%"+name+"%");
        ResultSet rs = null;
        Goods goods = null;
        if (null != connection) {//避免空指针异常
            rs = pstm.executeQuery();
            while (rs.next()) {
                goods = new Goods();
                goods.setGid(rs.getInt("Gid"));
                goods.setGname(rs.getString("Gname"));
                goods.setGprice(rs.getString("Gprice"));
                goods.setGurl(rs.getString("Gurl"));
                goods.setGlist_id(rs.getInt("Glist_id"));
                goodsList.add(goods);
            }
        }
        return goodsList;
    }

    @Override
    public Goods getGoodsBygid(Connection connection, int Gid) throws Exception {
        String sql = "select * from goods where Gid=?";
        Goods goods = new Goods();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Object[] param = {Gid};
        if (null != connection) {
            rs = BaseDao.execute(connection, pstm, rs, sql, param);
            if (rs.next()) {
                goods.setGid(rs.getInt(1));
                goods.setGname(rs.getString("Gname"));
                goods.setGprice(rs.getString("Gprice"));
                goods.setGurl(rs.getString("Gurl"));
                goods.setGlist_id(rs.getInt("Glist_id"));
                goods.setGdesc(rs.getString(6));
            }
        }
        return goods;
    }

    @Override
    public int insertGoods(Connection connection, int gid, int uid) throws Exception {
        int updateRows = 0;
        String sql = "insert into cart(Uid,Gid) values(?,?)";
        PreparedStatement pstm = null;
        Object[] param = {uid, gid};
        if (null != connection) {
            updateRows = BaseDao.executeUpdate(connection, pstm, sql, param);
        }
        return updateRows;
    }

    @Override
    public List<Goods> getCartGoods(Connection connection, int uid) throws Exception {
        List<Goods> goodsList = new ArrayList<>();
        String sql = "select * from goods  where gid in (SELECT gid from cart where uid=?)";
        Object[] param = {uid};
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Goods goods = null;
        if (null != connection) {
            rs = BaseDao.execute(connection, pstm, rs, sql, param);
            while (rs.next()) {
                goods = new Goods();
                goods.setGid(rs.getInt("Gid"));
                goods.setGname(rs.getString("Gname"));
                goods.setGprice(rs.getString("Gprice"));
                goods.setGurl(rs.getString("Gurl"));
                goods.setGlist_id(rs.getInt("Glist_id"));
                goodsList.add(goods);
            }
        }
        return goodsList;
    }


}
