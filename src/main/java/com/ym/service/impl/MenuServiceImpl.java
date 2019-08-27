package com.ym.service.impl;

import com.ym.mapper.MenuMapper;
import com.ym.pojo.Menu;
import com.ym.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;
    @Override
    public List<Menu> show() {
        return menuMapper.selByPid(0);
    }
}
