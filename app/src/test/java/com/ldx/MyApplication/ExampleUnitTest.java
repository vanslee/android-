package com.ldx.MyApplication;

import org.junit.Test;

import static org.junit.Assert.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ldx.MyApplication.bean.Actor;
import com.ldx.MyApplication.bean.ActorList;
import com.ldx.MyApplication.bean.ResponseResult;
import com.ldx.MyApplication.pojo.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void formatDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M/d");
        Date date = new Date();
        String format = simpleDateFormat.format(date);
        System.out.println("=====================================");
        System.out.println(format);
        System.out.println("=====================================");
    }

    @Test
    public void testData() {
        String resultData = "{\"code\":200,\"msg\":\"操作成功\",\"data\":{\"id\":null,\"phone\":\"147258369\",\"password\":\"qazwsxedc\"}}";
        ResponseResult<User> parse = JSON.parseObject(resultData, ResponseResult.class);
        User data = parse.getData();

        System.out.println(data.getPassword());
    }

    @Test
    public void testData1() {
        String data = "[{\"name\":\"李知恩\",\"description\":\"\\r\\n性别: 女\\r\\n星座: 金牛座\\r\\n出生日期: 1993年05月16日\\r\\n出生地: 韩国,首尔\\r\\n职业: 演员 / 主持人\\r\\n更多外文名: 아이유(艺名) / 이지은(本名) / Ji Eun Lee\\r\\n更多中文名: 李智恩\\r\\n家庭成员: 奶奶 李辰国(父) 妈妈 李钟勋(弟)\\r\\nimdb编号: nm4653224\",\"id\":1,\"avatar\":\"https://img9.doubanio.com/view/personage/raw/public/7e6a9efbcb2400d2f763985cddb3b266.jpg\"}]";
        JSONArray actorList = (JSONArray) JSONArray.parse(data);
        Actor jsonObject = JSON.parseObject((String) actorList.get(0), Actor.class);
//        System.out.println(jsonObject);
//        System.out.println(jsonObject.get("avatar"));
        System.out.println(actorList.get(0));
    }
    @Test
    public void testData2() {
        String regex = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
        String phone = "14725836911";
        boolean matches = Pattern.matches(regex, phone);
        System.out.println(matches);

    }
    @Test
    public void testData3() {
//        String regex = "/*fgg_again*/phone({\"meta\":{\"result\":\"0\",\"result_info\":\"\",\"jump_url\":\"\"},\"data\":{\"operator\":\"移动\",\"area\":\"四川\",\"area_operator\":\"四川移动\",\"support_price\":{\"10000\":\"9990\",\"20000\":\"19980\",\"30000\":\"29970\",\"5000\":\"4995\",\"50000\":\"49950\"},\"promotion_info\":null}})";
        String phone = "14725836911";
//        boolean matches = Pattern.matches(regex, phone);
//        System.out.println(matches);

    }
}