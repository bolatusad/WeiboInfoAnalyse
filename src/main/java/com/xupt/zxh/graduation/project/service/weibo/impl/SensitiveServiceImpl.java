package com.xupt.zxh.graduation.project.service.weibo.impl;

import com.hlin.sensitive.KWSeeker;
import com.hlin.sensitive.KeyWord;
import com.hlin.sensitive.SensitiveWordResult;
import com.xupt.zxh.graduation.project.bean.weibo.Sensitive;
import com.xupt.zxh.graduation.project.bean.weibo.WeiboInfo;
import com.xupt.zxh.graduation.project.bean.weibo.WeiboSensitive;
import com.xupt.zxh.graduation.project.dao.weibo.SensitiveDao;
import com.xupt.zxh.graduation.project.service.weibo.ISensitiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by 张涛 on 2017/5/27.
 */
@Service
public class SensitiveServiceImpl implements ISensitiveService {

    @Autowired
    private SensitiveDao sensitiveDao;


    /**
     * 敏感词搜索器
     */
    private Map<Integer,KWSeeker> mapKWSeeker;

    /*
      * 用于存储KeyWords
     */
    public static Map<Integer,Set<KeyWord>> keyWords;

    @Override
    public List<Sensitive> listAllSensitive() {
        List<Sensitive> sensitives = sensitiveDao.listAllSensitive();
        return sensitives;
    }

    @Override
    public void fillKeyWords() {
        List<Sensitive> sensitives = listAllSensitive();
        keyWords = new HashMap<Integer,Set<KeyWord>>();
        for(Sensitive sensitive : sensitives){
            Set<KeyWord> keyWordSet = keyWords.get(sensitive.getType());
            if(keyWordSet == null){
                keyWordSet = new HashSet<KeyWord>();
                keyWords.put(sensitive.getType(),keyWordSet);
            }
            KeyWord keyWord = new KeyWord(sensitive.getContent());
            keyWordSet.add(keyWord);
        }
    }

    /**
     * 填充敏感词搜索器
     */
    @Override
    public void fillKWSeeker(){
        mapKWSeeker = new HashMap<Integer,KWSeeker>();
        for(Integer type:keyWords.keySet()){
            KWSeeker kwSeeker = new KWSeeker(keyWords.get(type));
            mapKWSeeker.put(type,kwSeeker);
        }
    }

    @Override
    public void sensitiveAnalyse(WeiboInfo weiboInfo) {
        String weiboInfoStr = weiboInfo.toString();
        for (Integer type : mapKWSeeker.keySet()){
            KWSeeker kwSeeker = mapKWSeeker.get(type);
            List<SensitiveWordResult> sensitiveWordResults = kwSeeker.findWords(weiboInfoStr);
            if(sensitiveWordResults.size() >0){
                WeiboSensitive weiboSensitive = new WeiboSensitive();
                weiboSensitive.setWeiboId(weiboInfo.getId());
                weiboSensitive.setType(type);
                sensitiveDao.insertResult(weiboSensitive);
            }
        }

    }

    @Override
    public List<WeiboSensitive> listAllSensitiveResult() {
        List<WeiboSensitive> weiboSensitives = sensitiveDao.listAllSensitiveResult();
        return weiboSensitives;
    }
}
