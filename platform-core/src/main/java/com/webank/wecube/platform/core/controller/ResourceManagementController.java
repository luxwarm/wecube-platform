package com.webank.wecube.platform.core.controller;

import static com.webank.wecube.platform.core.dto.CommonResponseDto.okay;
import static com.webank.wecube.platform.core.dto.CommonResponseDto.okayWithData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.webank.wecube.platform.core.dto.CommonResponseDto;
import com.webank.wecube.platform.core.dto.QueryRequest;
import com.webank.wecube.platform.core.dto.ResourceItemDto;
import com.webank.wecube.platform.core.dto.ResourceServerDto;
import com.webank.wecube.platform.core.service.resource.ResourceItemStatus;
import com.webank.wecube.platform.core.service.resource.ResourceItemType;
import com.webank.wecube.platform.core.service.resource.ResourceManagementService;
import com.webank.wecube.platform.core.service.resource.ResourceServerStatus;
import com.webank.wecube.platform.core.service.resource.ResourceServerType;

@RestController
@RequestMapping("/resource")
public class ResourceManagementController {

    @Autowired
    private ResourceManagementService resourceService;

    @PostMapping("/servers/retrieve")
    public CommonResponseDto retrieveServers(@RequestBody QueryRequest queryRequest) {
        return okayWithData(resourceService.retrieveServers(queryRequest));
    }

    @PostMapping("/servers/create")
    public CommonResponseDto createServers(@RequestBody List<ResourceServerDto> resourceServers) {
        return okayWithData(resourceService.createServers(resourceServers));
    }

    @PostMapping("/servers/update")
    public CommonResponseDto updateServers(@RequestBody List<ResourceServerDto> resourceServers) {
        return okayWithData(resourceService.updateServers(resourceServers));
    }

    @PostMapping("/servers/delete")
    public CommonResponseDto deleteServers(@RequestBody List<ResourceServerDto> resourceServers) {
        resourceService.deleteServers(resourceServers);
        return okay();
    }

    @PostMapping("/items/retrieve")
    public CommonResponseDto retrieveItems(@RequestBody QueryRequest queryRequest) {
        return okayWithData(resourceService.retrieveItems(queryRequest));
    }

    @PostMapping("/items/create")
    public CommonResponseDto createItems(@RequestBody List<ResourceItemDto> resourceItems) {
        return okayWithData(resourceService.createItems(resourceItems));
    }

    @PostMapping("/items/update")
    public CommonResponseDto updateItems(@RequestBody List<ResourceItemDto> resourceItems) {
        return okayWithData(resourceService.updateItems(resourceItems));
    }

    @PostMapping("/items/delete")
    public CommonResponseDto deleteItems(@RequestBody List<ResourceItemDto> resourceItems) {
        resourceService.deleteItems(resourceItems);
        return okay();
    }

    @GetMapping("/constants/resource-server-types")
    public CommonResponseDto getResourceServerType() {
        List<String> resourceServerTypes = Lists.newLinkedList();
        for (ResourceServerType type : ResourceServerType.values()) {
            if (ResourceServerType.NONE.equals(type))
                continue;

            resourceServerTypes.add(type.getCode());
        }
        return okayWithData(resourceServerTypes);
    }

    @GetMapping("/constants/resource-item-types")
    public CommonResponseDto getResourceItemType() {
        List<String> resourceItemTypes = Lists.newLinkedList();
        for (ResourceItemType type : ResourceItemType.values()) {
            if (ResourceItemType.NONE.equals(type))
                continue;

            resourceItemTypes.add(type.getCode());
        }
        return okayWithData(resourceItemTypes);
    }

    @GetMapping("/constants/resource-server-status")
    public CommonResponseDto getResourceServerStatus() {
        List<String> resourceServerStatus = Lists.newLinkedList();
        for (ResourceServerStatus type : ResourceServerStatus.values()) {
            if (ResourceServerStatus.NONE.equals(type))
                continue;

            resourceServerStatus.add(type.getCode());
        }
        return okayWithData(resourceServerStatus);
    }

    @GetMapping("/constants/resource-item-status")
    public CommonResponseDto getResourceItemStatus() {
        List<String> resourceItemStatus = Lists.newLinkedList();
        for (ResourceItemStatus type : ResourceItemStatus.values()) {
            if (ResourceItemStatus.NONE.equals(type))
                continue;

            resourceItemStatus.add(type.getCode());
        }
        return okayWithData(resourceItemStatus);
    }
}
