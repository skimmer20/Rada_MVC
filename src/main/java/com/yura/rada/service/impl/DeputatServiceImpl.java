package com.yura.rada.service.impl;

import com.yura.rada.dao.DeputatDao;
import com.yura.rada.model.Deputat;
import com.yura.rada.service.DeputatService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author yuriismac on 2020-06-06.
 * @project VerkhovnaRada
 */

@Service
public class DeputatServiceImpl implements DeputatService {

    private DeputatDao deputatDao;

    public void setDeputatDao(DeputatDao deputatDao) {
        this.deputatDao = deputatDao;
    }

    @Override
    @Transactional
    public void addDeputat(Deputat deputat) {
        this.deputatDao.addDeputat(deputat);
    }

    @Override
    @Transactional
    public void updateDeputat(Deputat deputat) {
        this.deputatDao.updateDeputat(deputat);
    }

    @Override
    @Transactional
    public void removeDeputat(int id) {
        this.deputatDao.removeDeputat(id);
    }

    @Override
    @Transactional
    public Deputat getDeputatById(int id) {
        return deputatDao.getDeputatById(id);
    }

    @Override
    @Transactional
    public List<Deputat> listDeputats() {
        return this.deputatDao.listDeputats();
    }
}
