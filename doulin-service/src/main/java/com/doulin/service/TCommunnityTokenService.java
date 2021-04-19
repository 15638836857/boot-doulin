package com.doulin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.doulin.entity.TCommunnityToken;
import com.doulin.entity.vo.VQuery;

import java.util.List;

/**
* TCommunnityTokenService
* @Author malinging
* @Date 2021-04-19
**/
public interface TCommunnityTokenService extends IService<TCommunnityToken> {

    IPage<TCommunnityToken> page(VQuery query);

    List<TCommunnityToken> getByToken(String token);
}
