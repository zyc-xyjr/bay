package com.bm.service.impl;

import com.bm.dao.PathogenDao;
import com.bm.entity.CheckEntry;
import com.bm.entity.Pathogen;
import com.bm.service.PathogenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/12.
 */
@Service("pathogenService")
public class PathogenServiceImpl implements PathogenService {
    @Autowired
    private PathogenDao pathogenDao;

    @Override
    public void savePathogen(Pathogen pathogen) {
        this.pathogenDao.save(pathogen);
    }

    @Override
    public List<Pathogen> findAllPathogen() {
        return (List<Pathogen>) this.pathogenDao.findAll();
    }

    @Override
    public void removePathogen(long id) {
        this.pathogenDao.delete(id);
    }

    @Override
    public Page<Pathogen> pageAllPathogen(int pageNo, int pageSize) {
        PageRequest request = new PageRequest(pageNo-1,pageSize,null);
        Page<Pathogen> pathogenPage = this.pathogenDao.findAll(request);
        return pathogenPage;
    }

    @Override
    public void batchDelPathogen(List<Long> idList) {
        List<Pathogen> pathogens =(List<Pathogen>) this.pathogenDao.findAll(idList);
        this.pathogenDao.delete(pathogens);
    }
}
