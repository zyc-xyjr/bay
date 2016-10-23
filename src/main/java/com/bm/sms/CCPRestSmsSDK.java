package com.bm.sms;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import com.bm.utils.CcopHttpClient;
import com.bm.utils.DateUtil;
import com.bm.utils.EncryptUtil;
import com.bm.utils.LoggerUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class CCPRestSmsSDK {
    private static final int Request_Get = 0;
    private static final int Request_Post = 1;
    private static final String TemplateSMS = "SMS/TemplateSMS";
    private String SERVER_IP;
    private String SERVER_PORT;
    private String ACCOUNT_SID;
    private String ACCOUNT_TOKEN;
    public String App_ID;
    private CCPRestSmsSDK.BodyType BODY_TYPE;

    public CCPRestSmsSDK() {
        this.BODY_TYPE = CCPRestSmsSDK.BodyType.Type_JSON;
    }

    public void init(String serverIP, String serverPort) {
        if(!this.isEmpty(serverIP) && !this.isEmpty(serverPort)) {
            this.SERVER_IP = serverIP;
            this.SERVER_PORT = serverPort;
        } else {
            LoggerUtil.fatal("初始化异常:serverIP或serverPort为空");
            throw new IllegalArgumentException("必选参数:" + (this.isEmpty(serverIP)?" 服务器地址 ":"") + (this.isEmpty(serverPort)?" 服务器端口 ":"") + "为空");
        }
    }

    public void setAccount(String accountSid, String accountToken) {
        if(!this.isEmpty(accountSid) && !this.isEmpty(accountToken)) {
            this.ACCOUNT_SID = accountSid;
            this.ACCOUNT_TOKEN = accountToken;
        } else {
            LoggerUtil.fatal("初始化异常:accountSid或accountToken为空");
            throw new IllegalArgumentException("必选参数:" + (this.isEmpty(accountSid)?" 主帐号名称":"") + (this.isEmpty(accountToken)?" 主帐号令牌 ":"") + "为空");
        }
    }

    public void setAppId(String appId) {
        if(this.isEmpty(appId)) {
            LoggerUtil.fatal("初始化异常:appId为空");
            throw new IllegalArgumentException("必选参数: 应用Id 为空");
        } else {
            this.App_ID = appId;
        }
    }

    public HashMap<String, Object> sendTemplateSMS(String to, String templateId, String[] datas) {
        HashMap validate = this.accountValidate();
        if(validate != null) {
            return validate;
        } else if(!this.isEmpty(to) && !this.isEmpty(this.App_ID) && !this.isEmpty(templateId)) {
            CcopHttpClient chc = new CcopHttpClient();
            DefaultHttpClient httpclient = null;

            try {
                httpclient = chc.registerSSL(this.SERVER_IP, "TLS", Integer.parseInt(this.SERVER_PORT), "https");
            } catch (Exception var24) {
                var24.printStackTrace();
                throw new RuntimeException("初始化httpclient异常" + var24.getMessage());
            }

            String result = "";

            label252: {
                HashMap var17;
                try {
                    HttpPost e = (HttpPost)this.getHttpRequestBase(1, "SMS/TemplateSMS");
                    String requsetbody = "";
                    int Jarray;
                    if(this.BODY_TYPE == CCPRestSmsSDK.BodyType.Type_JSON) {
                        JsonObject var29 = new JsonObject();
                        var29.addProperty("appId", this.App_ID);
                        var29.addProperty("to", to);
                        var29.addProperty("templateId", templateId);
                        if(datas != null) {
                            StringBuilder var28 = new StringBuilder("[");
                            String[] var15 = datas;
                            int var36 = datas.length;

                            for(Jarray = 0; Jarray < var36; ++Jarray) {
                                String var31 = var15[Jarray];
                                var28.append("\"" + var31 + "\"" + ",");
                            }

                            var28.replace(var28.length() - 1, var28.length(), "]");
                            JsonParser var34 = new JsonParser();
                            JsonArray var33 = var34.parse(var28.toString()).getAsJsonArray();
                            var29.add("datas", var33);
                        }

                        requsetbody = var29.toString();
                    } else {
                        StringBuilder requestBody = new StringBuilder("<?xml version=\'1.0\' encoding=\'utf-8\'?><TemplateSMS>");
                        requestBody.append("<appId>").append(this.App_ID).append("</appId>").append("<to>").append(to).append("</to>").append("<templateId>").append(templateId).append("</templateId>");
                        if(datas != null) {
                            requestBody.append("<datas>");
                            String[] var14 = datas;
                            Jarray = datas.length;

                            for(int entity = 0; entity < Jarray; ++entity) {
                                String response = var14[entity];
                                requestBody.append("<data>").append(response).append("</data>");
                            }

                            requestBody.append("</datas>");
                        }

                        requestBody.append("</TemplateSMS>").toString();
                        requsetbody = requestBody.toString();
                    }

                    LoggerUtil.info("sendTemplateSMS Request body =  " + requsetbody);
                    BasicHttpEntity var30 = new BasicHttpEntity();
                    var30.setContent(new ByteArrayInputStream(requsetbody.getBytes("UTF-8")));
                    var30.setContentLength((long)requsetbody.getBytes("UTF-8").length);
                    e.setEntity(var30);
                    HttpResponse var32 = httpclient.execute(e);
                    HttpEntity var35 = var32.getEntity();
                    if(var35 != null) {
                        result = EntityUtils.toString(var35, "UTF-8");
                    }

                    EntityUtils.consume(var35);
                    break label252;
                } catch (IOException var25) {
                    var25.printStackTrace();
                    LoggerUtil.error(var25.getMessage());
                    var17 = this.getMyError("172001", "网络错误");
                    return var17;
                } catch (Exception var26) {
                    var26.printStackTrace();
                    LoggerUtil.error(var26.getMessage());
                    var17 = this.getMyError("172002", "无返回");
                } finally {
                    if(httpclient != null) {
                        httpclient.getConnectionManager().shutdown();
                    }

                }

                return var17;
            }

            LoggerUtil.info("sendTemplateSMS response body = " + result);

            try {
                return this.BODY_TYPE == CCPRestSmsSDK.BodyType.Type_JSON?this.jsonToMap(result):this.xmlToMap(result);
            } catch (Exception var23) {
                return this.getMyError("172003", "返回包体错误");
            }
        } else {
            throw new IllegalArgumentException("必选参数:" + (this.isEmpty(to)?" 手机号码 ":"") + (this.isEmpty(templateId)?" 模板Id ":"") + "为空");
        }
    }

    private HashMap<String, Object> jsonToMap(String result) {
        HashMap hashMap = new HashMap();
        JsonParser parser = new JsonParser();
        JsonObject asJsonObject = parser.parse(result).getAsJsonObject();
        Set entrySet = asJsonObject.entrySet();
        HashMap hashMap2 = new HashMap();
        Iterator var8 = entrySet.iterator();

        while(var8.hasNext()) {
            Entry m = (Entry)var8.next();
            if(!"statusCode".equals(m.getKey()) && !"statusMsg".equals(m.getKey())) {
                if(!"SubAccount".equals(m.getKey()) && !"totalCount".equals(m.getKey()) && !"token".equals(m.getKey()) && !"downUrl".equals(m.getKey())) {
                    JsonObject asJsonObject21 = parser.parse(((JsonElement)m.getValue()).toString()).getAsJsonObject();
                    Set entrySet22 = asJsonObject21.entrySet();
                    HashMap hashMap33 = new HashMap();
                    Iterator m25 = entrySet22.iterator();

                    while(m25.hasNext()) {
                        Entry m24 = (Entry)m25.next();
                        hashMap33.put((String)m24.getKey(), ((JsonElement)m24.getValue()).getAsString());
                    }

                    if(hashMap33.size() != 0) {
                        hashMap2.put((String)m.getKey(), hashMap33);
                    } else {
                        hashMap2.put((String)m.getKey(), ((JsonElement)m.getValue()).getAsString());
                    }

                    hashMap.put("data", hashMap2);
                } else {
                    if(!"SubAccount".equals(m.getKey())) {
                        hashMap2.put((String)m.getKey(), ((JsonElement)m.getValue()).getAsString());
                    } else {
                        try {
                            if(((JsonElement)m.getValue()).toString().trim().length() <= 2 && !((JsonElement)m.getValue()).toString().contains("[")) {
                                hashMap2.put((String)m.getKey(), ((JsonElement)m.getValue()).getAsString());
                                hashMap.put("data", hashMap2);
                                break;
                            }

                            if(((JsonElement)m.getValue()).toString().contains("[]")) {
                                hashMap2.put((String)m.getKey(), new JsonArray());
                                hashMap.put("data", hashMap2);
                                continue;
                            }

                            JsonArray asJsonObject2 = parser.parse(((JsonElement)m.getValue()).toString()).getAsJsonArray();
                            ArrayList entrySet21 = new ArrayList();
                            Iterator m23 = asJsonObject2.iterator();

                            while(m23.hasNext()) {
                                JsonElement hashMap32 = (JsonElement)m23.next();
                                Set m26 = hashMap32.getAsJsonObject().entrySet();
                                HashMap hashMap34 = new HashMap();
                                Iterator var16 = m26.iterator();

                                while(var16.hasNext()) {
                                    Entry m22 = (Entry)var16.next();
                                    hashMap34.put((String)m22.getKey(), ((JsonElement)m22.getValue()).getAsString());
                                }

                                entrySet21.add(hashMap34);
                            }

                            hashMap2.put("SubAccount", entrySet21);
                        } catch (Exception var17) {
                            JsonObject entrySet2 = parser.parse(((JsonElement)m.getValue()).toString()).getAsJsonObject();
                            Set hashMap3 = entrySet2.entrySet();
                            HashMap m2 = new HashMap();
                            Iterator hashMap31 = hashMap3.iterator();

                            while(hashMap31.hasNext()) {
                                Entry m21 = (Entry)hashMap31.next();
                                m2.put((String)m21.getKey(), ((JsonElement)m21.getValue()).getAsString());
                            }

                            hashMap2.put((String)m.getKey(), m2);
                            hashMap.put("data", hashMap2);
                        }
                    }

                    hashMap.put("data", hashMap2);
                }
            } else {
                hashMap.put((String)m.getKey(), ((JsonElement)m.getValue()).getAsString());
            }
        }

        return hashMap;
    }

    private HashMap<String, Object> xmlToMap(String xml) {
        HashMap map = new HashMap();
        Document doc = null;

        try {
            doc = DocumentHelper.parseText(xml);
            Element e = doc.getRootElement();
            HashMap hashMap2 = new HashMap();
            Iterator i = e.elementIterator();

            while(true) {
                while(true) {
                    while(i.hasNext()) {
                        Element e1 = (Element)i.next();
                        if(!"statusCode".equals(e1.getName()) && !"statusMsg".equals(e1.getName())) {
                            if(!"SubAccount".equals(e1.getName()) && !"totalCount".equals(e1.getName()) && !"token".equals(e1.getName()) && !"downUrl".equals(e1.getName())) {
                                HashMap hashMap31 = new HashMap();
                                Iterator i21 = e1.elementIterator();

                                while(i21.hasNext()) {
                                    Element e22 = (Element)i21.next();
                                    hashMap31.put(e22.getName(), e22.getText());
                                }

                                if(hashMap31.size() != 0) {
                                    hashMap2.put(e1.getName(), hashMap31);
                                } else {
                                    hashMap2.put(e1.getName(), e1.getText());
                                }

                                map.put("data", hashMap2);
                            } else {
                                if(!"SubAccount".equals(e1.getName())) {
                                    hashMap2.put(e1.getName(), e1.getText());
                                } else {
                                    ArrayList hashMap3 = new ArrayList();
                                    HashMap i2 = new HashMap();
                                    Iterator e2 = e1.elementIterator();

                                    while(e2.hasNext()) {
                                        Element e21 = (Element)e2.next();
                                        i2.put(e21.getName(), e21.getText());
                                        hashMap3.add(i2);
                                    }

                                    hashMap2.put("SubAccount", hashMap3);
                                }

                                map.put("data", hashMap2);
                            }
                        } else {
                            map.put(e1.getName(), e1.getText());
                        }
                    }

                    return map;
                }
            }
        } catch (DocumentException var12) {
            var12.printStackTrace();
            LoggerUtil.error(var12.getMessage());
        } catch (Exception var13) {
            LoggerUtil.error(var13.getMessage());
            var13.printStackTrace();
        }

        return map;
    }

    private HttpRequestBase getHttpRequestBase(int get, String action) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String timestamp = DateUtil.dateToStr(new Date(), 5);
        EncryptUtil eu = new EncryptUtil();
        String sig = "";
        String acountName = "";
        String acountType = "Accounts";
        acountName = this.ACCOUNT_SID;
        sig = this.ACCOUNT_SID + this.ACCOUNT_TOKEN + timestamp;
        String signature = eu.md5Digest(sig);
        String url = this.getBaseUrl().append("/" + acountType + "/").append(acountName).append("/" + action + "?sig=").append(signature).toString();
        LoggerUtil.info(this.getmethodName(action) + " url = " + url);
        Object mHttpRequestBase = null;
        if(get == 0) {
            mHttpRequestBase = new HttpGet(url);
        } else if(get == 1) {
            mHttpRequestBase = new HttpPost(url);
        }

        this.setHttpHeader((AbstractHttpMessage)mHttpRequestBase);
        String src = acountName + ":" + timestamp;
        String auth = eu.base64Encoder(src);
        ((HttpRequestBase)mHttpRequestBase).setHeader("Authorization", auth);
        return (HttpRequestBase)mHttpRequestBase;
    }

    private String getmethodName(String action) {
        return action.equals("SMS/TemplateSMS")?"sendTemplateSMS":"";
    }

    private void setHttpHeader(AbstractHttpMessage httpMessage) {
        if(this.BODY_TYPE == CCPRestSmsSDK.BodyType.Type_JSON) {
            httpMessage.setHeader("Accept", "application/json");
            httpMessage.setHeader("Content-Type", "application/json;charset=utf-8");
        } else {
            httpMessage.setHeader("Accept", "application/xml");
            httpMessage.setHeader("Content-Type", "application/xml;charset=utf-8");
        }

    }

    private StringBuffer getBaseUrl() {
        StringBuffer sb = new StringBuffer("https://");
        sb.append(this.SERVER_IP).append(":").append(this.SERVER_PORT);
        sb.append("/2013-12-26");
        return sb;
    }

    private boolean isEmpty(String str) {
        return "".equals(str) || str == null;
    }

    private HashMap<String, Object> getMyError(String code, String msg) {
        HashMap hashMap = new HashMap();
        hashMap.put("statusCode", code);
        hashMap.put("statusMsg", msg);
        return hashMap;
    }

    private HashMap<String, Object> accountValidate() {
        return this.isEmpty(this.SERVER_IP)?this.getMyError("172004", "IP为空"):(this.isEmpty(this.SERVER_PORT)?this.getMyError("172005", "端口错误"):(this.isEmpty(this.ACCOUNT_SID)?this.getMyError("172006", "主帐号为空"):(this.isEmpty(this.ACCOUNT_TOKEN)?this.getMyError("172007", "主帐号令牌为空"):(this.isEmpty(this.App_ID)?this.getMyError("172012", "应用ID为空"):null))));
    }

    public static enum AccountType {
        Accounts,
        SubAccounts;

        private AccountType() {
        }
    }

    public static enum BodyType {
        Type_XML,
        Type_JSON;

        private BodyType() {
        }
    }
}
