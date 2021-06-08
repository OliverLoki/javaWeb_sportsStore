package smbms.services.goods;

import smbms.pojo.Goods;

import java.util.List;

public interface GoodsServices {
    /**
     * @return 返回所有商品
     */
    public List<Goods> getAllGoods();

    /**
     * @param listId
     * @return 返回分类商品
     */
    public List<Goods> getGoods(int listId);

    /**
     * @param gid
     * @return
     */
    public Goods getGoodsByGid(int gid);

    public List<Goods> getGoodsByName(String name);

    /**
     * @param gid
     * @param uid
     * @return 返回购物车表中受影响的行数
     */
    public int insertgoods(int gid,int uid);

    /**
     * @param uid
     * @return 返回当前用户购物车中商品
     */
    public List<Goods> getCartGoods(int uid);

}
