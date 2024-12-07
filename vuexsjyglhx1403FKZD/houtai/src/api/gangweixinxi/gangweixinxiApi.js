import request from '@/utils/request';
// list
export const gangweixinxiList = (params) => {
    return request({
        url: '/gangweixinxi/page',
        method: 'post',
        data: params,
    })
};
export const gangweixinxiDetail = (id) => {
    return request({
        url: '/gangweixinxi/'+id,
        method: 'get',
    })
};
// add
export const gangweixinxiSave = (params) => {
    return request({
        url: '/gangweixinxi',
        method: 'post',
        data: params,
    })
};
// updt
export const gangweixinxiEdit = (params) => {
    return request({
        url: '/gangweixinxi',
        method: 'put',
        data: params,
    })
};
// delete
export const gangweixinxiDelete = (id) => {
    return request({
        url: '/gangweixinxi/'+id,
        method: 'delete',
    })
};
// pldel
export const gangweixinxiDeleteList = (gangweixinxis) => {
    return request({
        url: '/gangweixinxi/deleteList',
        data:{list:gangweixinxis},
        method: 'post',
    })
};
// all
export const gangweixinxiAllList = () => {
    return request({
        url: '/gangweixinxi',
        method: 'get',
    })
};

