package smbms.dao.goods;

import smbms.pojo.Good_List;
import smbms.pojo.Goods;

import java.sql.Connection;
import java.util.List;

public interface GoodsDao {

    /**
     * @return 全部商品
     */
    public List<Goods> getAllGoods(Connection connection) throws Exception;

    /**
     * 传入Glist_id
     *
     * @return 根据商品分类id返回特定商品
     */
    public List<Goods> getGoods(Connection connection, int listId) throws Exception;

    /**
      * @param connection
     * @param name
     * @return 返回一个商品列表
     * @throws Exception
     */
    public List<Goods> getGoodsByName(Connection connection,String name) throws Exception;

    /**
     * 通过gid获取该商品
     * @param Gid
     * @param connection
     * @return
     * @throws Exception
     */
    public Goods getGoodsBygid(Connection connection, int Gid) throws Exception;

    /**
     * 向购物车表中传入Gid和ListID属性
     * @param connection
     * @param gid
     * @param uid
     * @return
     * @throws Exception
     */
    public int insertGoods(Connection connection, int gid, int uid) throws Exception;

    public List<Goods> getCartGoods(Connection connection, int uid) throws Exception;

}
