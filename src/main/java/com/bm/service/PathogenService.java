package com.bm.service;


import com.bm.entity.Pathogen;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/9/12.
 */
public interface PathogenService {
    void savePathogen(Pathogen pathogen);

    List<Pathogen> findAllPathogen();

    void removePathogen(long id);

    Page<Pathogen> pageAllPathogen(int pageNo,int pageSize);

    void batchDelPathogen(List<Long> idList);

}
