package com.george.mybatisplus.service.impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.george.mybatisplus.domain.entity.Address;
import com.george.mybatisplus.mapper.AddressMapper;
import com.george.mybatisplus.service.IAddressService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author author
 * @since 2026-09-01
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}
