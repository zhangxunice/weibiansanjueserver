package com.example.weibiansanjueserver.service.impl;

import com.example.weibiansanjueserver.dao.ChapterDao;
import com.example.weibiansanjueserver.entity.Chapter;
import com.example.weibiansanjueserver.service.ChapterService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/23 17:14
 */

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDao chapterDao;

    @Autowired
    private Sid sid;

    @Override
    public void saveChapter(Chapter chapter) {
        String id=sid.nextShort();
        chapter.setChapterId(id);
        chapterDao.insert(chapter);

    }
}
