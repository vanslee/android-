package com.ldx.MyApplication.constants;

public interface SystemContains {
    /**
     * 登录接口
     *
     * @param User
     * @method POST
     */
    public static String loginURL = "http://192.168.42.3:8080/user/login";
    /**
     * 注册接口
     *
     * @param User
     * @method POST
     */
    public static String registryURL = "http://192.168.42.3:8080/user/registry";
    public static String name = "";
    public static String param = "";
    public static String historyontodayURL = "http://v.juhe.cn/todayOnhistory/queryEvent.php?key=236521a777a86d154e41e74a8838b9df&date=";
    public static String getNBANews = "http://apis.juhe.cn/fapig/nba/query?key=";
    public static String key = "93db82c4172c1182c3c43d41f672ae39";
    // 新闻列表查询
    /**
     * type: string 非必填 top(推荐,默认)guonei(国内)guoji(国际)yule(娱乐)tiyu(体育)junshi(军事)keji(科技)caijing(财经)youxi(游戏)qiche(汽车)jiankang(健康)
     * page: int 当前页 非必填 默认1,最大0
     * page_size: int 返回条数 非必填 默认30 最大30
     * is_filter: int 是否只返回有内容详情得新闻 非必填 1:是 默认:0
     */
    public static String toutiaoURL = "http://v.juhe.cn/toutiao/index?tpye=guoji&page=1&page_size=15&is_filter=1";
    public static String GETMETHOD = "GET";
    public static String POSTMETHOD = "POST";
    public static String CONTENT_TYPE = "Content-Type";
    public static String FORMART = "application/json";
    public static String FORMART_OBJECT = "application/x-java-serialized-object";
    String TAG = "TAG";
    int BYTE_LENGTH = 1024;


    // 获取明星数据
    public static String GET_ALL_ACTORS = "http://192.168.42.3:8080/actor/1/5";

    // 电话查询数据
    String QUERY_PHONE = "http://192.168.42.3:8080/query/phone?phone=";
    String PHONE_REGEX = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
    // 退出登录
    String logoutURL = "http://192.168.42.3:8080/user/logout";
}
