package com.example.acer.jd.com.bwie.model.bean;

import java.util.List;

/**
 * Created by acer on 2018/10/20.
 */

public class CarBean {
    /**
     * msg : 请求成功
     * code : 0
     * data : [{"list":[{"bargainPrice":3455,"createtime":"2017-10-14T21:38:26","detailUrl":"https://item.m.jd.com/product/12224420750.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8803/356/1478945529/489755/2a163ace/59ba5e84N7bb9a666.jpg!q70.jpg","num":1,"pid":48,"price":222,"pscid":39,"selected":0,"sellerid":4,"subhead":"【现货新品抢购】全面屏2.0震撼来袭，骁龙835处理器，四曲面陶瓷机","title":"小米（MI） 小米MIX2 手机 黑色 全网通 (6GB+64GB)【标配版】"}],"sellerName":"商家4","sellerid":"4"},{"list":[{"bargainPrice":1999,"createtime":"2017-10-10T16:09:02","detailUrl":"https://item.m.jd.com/product/5025971.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t7210/232/3738666823/232298/9004583e/59c3a9a7N8de42e15.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8356/82/2107423621/109733/c019b8c6/59c3a9a6Ne9a4bdd7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t10219/74/25356012/171379/7d55e296/59c3a9a8N82fa6e02.jpg!q70.jpg","num":1,"pid":49,"price":333,"pscid":39,"selected":0,"sellerid":5,"subhead":"vivo X20 带你开启全面屏时代！逆光也清晰，照亮你的美！","title":"vivo X20 全面屏手机 全网通 4GB+64GB 金色 移动联通电信4G手机 双卡双待"}],"sellerName":"商家5","sellerid":"5"},{"list":[{"bargainPrice":3455,"createtime":"2017-10-14T21:38:26","detailUrl":"https://item.m.jd.com/product/12224420750.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8803/356/1478945529/489755/2a163ace/59ba5e84N7bb9a666.jpg!q70.jpg","num":1,"pid":51,"price":555,"pscid":39,"selected":0,"sellerid":7,"subhead":"【现货新品抢购】全面屏2.0震撼来袭，骁龙835处理器，四曲面陶瓷机","title":"小米（MI） 小米MIX2 手机 黑色 全网通 (6GB+64GB)【标配版】"}],"sellerName":"商家7","sellerid":"7"},{"list":[{"bargainPrice":22.9,"createtime":"2017-10-14T21:38:26","detailUrl":"https://item.m.jd.com/product/2542855.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t1930/284/2865629620/390243/e3ade9c4/56f0a08fNbd3a1235.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t2137/336/2802996626/155915/e5e90d7a/56f0a09cN33e01bd0.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t1882/31/2772215910/389956/c8dbf370/56f0a0a2Na0c86ea6.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t2620/166/2703833710/312660/531aa913/57709035N33857877.jpg!q70.jpg","num":2,"pid":32,"price":888,"pscid":2,"selected":0,"sellerid":9,"subhead":"三只松鼠零食特惠，专区满99减50，满199减100，火速抢购》","title":"三只松鼠 坚果炒货 零食奶油味 碧根果225g/袋"}],"sellerName":"商家9","sellerid":"9"}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * list : [{"bargainPrice":3455,"createtime":"2017-10-14T21:38:26","detailUrl":"https://item.m.jd.com/product/12224420750.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8803/356/1478945529/489755/2a163ace/59ba5e84N7bb9a666.jpg!q70.jpg","num":1,"pid":48,"price":222,"pscid":39,"selected":0,"sellerid":4,"subhead":"【现货新品抢购】全面屏2.0震撼来袭，骁龙835处理器，四曲面陶瓷机","title":"小米（MI） 小米MIX2 手机 黑色 全网通 (6GB+64GB)【标配版】"}]
         * sellerName : 商家4
         * sellerid : 4
         */

        private String sellerName;
        private String sellerid;
        private List<ListBean> list;
        private boolean isOutCheck;

        public boolean isOutCheck() {
            return isOutCheck;
        }

        public void setOutCheck(boolean outCheck) {
            isOutCheck = outCheck;
        }

        public String getSellerName() {
            return sellerName;
        }

        public void setSellerName(String sellerName) {
            this.sellerName = sellerName;
        }

        public String getSellerid() {
            return sellerid;
        }

        public void setSellerid(String sellerid) {
            this.sellerid = sellerid;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * bargainPrice : 3455.0
             * createtime : 2017-10-14T21:38:26
             * detailUrl : https://item.m.jd.com/product/12224420750.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends
             * images : https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8803/356/1478945529/489755/2a163ace/59ba5e84N7bb9a666.jpg!q70.jpg
             * num : 1
             * pid : 48
             * price : 222.0
             * pscid : 39
             * selected : 0
             * sellerid : 4
             * subhead : 【现货新品抢购】全面屏2.0震撼来袭，骁龙835处理器，四曲面陶瓷机
             * title : 小米（MI） 小米MIX2 手机 黑色 全网通 (6GB+64GB)【标配版】
             */

            private double bargainPrice;
            private String createtime;
            private String detailUrl;
            private String images;
            private int num;
            private int pid;
            private double price;
            private int pscid;
            private int selected;
            private int sellerid;
            private String subhead;
            private String title;
            private boolean isInCheck;

            public void setInCheck(boolean inCheck) {
                isInCheck = inCheck;
            }

            public boolean isInCheck() {
                return isInCheck;
            }

            public double getBargainPrice() {
                return bargainPrice;
            }

            public void setBargainPrice(double bargainPrice) {
                this.bargainPrice = bargainPrice;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getDetailUrl() {
                return detailUrl;
            }

            public void setDetailUrl(String detailUrl) {
                this.detailUrl = detailUrl;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getPscid() {
                return pscid;
            }

            public void setPscid(int pscid) {
                this.pscid = pscid;
            }

            public int getSelected() {
                return selected;
            }

            public void setSelected(int selected) {
                this.selected = selected;
            }

            public int getSellerid() {
                return sellerid;
            }

            public void setSellerid(int sellerid) {
                this.sellerid = sellerid;
            }

            public String getSubhead() {
                return subhead;
            }

            public void setSubhead(String subhead) {
                this.subhead = subhead;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
