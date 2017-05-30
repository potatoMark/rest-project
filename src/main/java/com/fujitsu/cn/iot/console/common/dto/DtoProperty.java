package com.fujitsu.cn.iot.console.common.dto;

/**
 * Created by mark on 2017/4/21.
 */
public class DtoProperty {

    public static final String[] key = new String[] {"Level1","Level2"
            ,"Level3","Level4","Level5","MetCd","DevCd"};

    //TagJson
    public static final String[] tagInfo = new String[]{"Level1","Level2"
            ,"Level3","Level4","Level5","MetCd","DevCd","Math"
            ,"Status","Unit","ItemId","Timer","Batch","DevTyp","DataType","Tag"};

    public static final String[] mqttInfo = new String[]{"MqCd","MqNm","MqPwd","MqUser","Url"};

    public static final String[] opcInfo = new String[]{"KepNm","KepCd","ClsId","Ip","KepPwd","Domain","KepUser"};

    public static final String[] complexInfo = new String[]{"Group","TagCd","Symbol","Seq"};


    //table
    public static final String[] deviceManager = new String[]{"Level1","Level2"
            ,"Level3","Level4","Level5","DevCd","MetCd"
            ,"AdrId","GwCd","OnOff","Status","KepCd","MqCd"};

    public static final String[] tagTimer = new String[]{
        "TagManagerId","Level1","ItemId","Batch","Timer","OnOff"
    };
}
