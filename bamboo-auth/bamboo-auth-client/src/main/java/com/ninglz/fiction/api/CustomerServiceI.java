package com.ninglz.fiction.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.ninglz.fiction.dto.CustomerAddCmd;
import com.ninglz.fiction.dto.CustomerListByNameQry;
import com.ninglz.fiction.dto.data.CustomerDTO;

public interface CustomerServiceI {

    public Response addCustomer(CustomerAddCmd customerAddCmd);

    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
