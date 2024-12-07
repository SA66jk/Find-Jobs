import request from '@/utils/request';
// list
export const jianlixinxiList = (params) => {
    return request({
        url: '/jianlixinxi/page',
        method: 'post',
        data: params,
    })
};
export const jianlixinxiDetail = (id) => {
    return request({
        url: '/jianlixinxi/'+id,
        method: 'get',
    })
};
// add
export const jianlixinxiSave = (params) => {
    return request({
        url: '/jianlixinxi',
        method: 'post',
        data: params,
    })
};
// updt
export const jianlixinxiEdit = (params) => {
    return request({
        url: '/jianlixinxi',
        method: 'put',
        data: params,
    })
};
// delete
export const jianlixinxiDelete = (id) => {
    return request({
        url: '/jianlixinxi/'+id,
        method: 'delete',
    })
};
// pldel
export const jianlixinxiDeleteList = (jianlixinxis) => {
    return request({
        url: '/jianlixinxi/deleteList',
        data:{list:jianlixinxis},
        method: 'post',
    })
};
// all
export const jianlixinxiAllList = () => {
    return request({
        url: '/jianlixinxi',
        method: 'get',
    })
};

