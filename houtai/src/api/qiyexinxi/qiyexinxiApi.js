import request from '@/utils/request';
// list
export const qiyexinxiList = (params) => {
    return request({
        url: '/qiyexinxi/page',
        method: 'post',
        data: params,
    })
};
export const qiyexinxiDetail = (id) => {
    return request({
        url: '/qiyexinxi/'+id,
        method: 'get',
    })
};
// add
export const qiyexinxiSave = (params) => {
    return request({
        url: '/qiyexinxi',
        method: 'post',
        data: params,
    })
};
// updt
export const qiyexinxiEdit = (params) => {
    return request({
        url: '/qiyexinxi',
        method: 'put',
        data: params,
    })
};
// delete
export const qiyexinxiDelete = (id) => {
    return request({
        url: '/qiyexinxi/'+id,
        method: 'delete',
    })
};
// pldel
export const qiyexinxiDeleteList = (qiyexinxis) => {
    return request({
        url: '/qiyexinxi/deleteList',
        data:{list:qiyexinxis},
        method: 'post',
    })
};
// all
export const qiyexinxiAllList = () => {
    return request({
        url: '/qiyexinxi',
        method: 'get',
    })
};
export const qiyexinxiUpdatePassword = (params) =>{ return request({ url: `/qiyexinxi/updatePassword`, method: 'put',data: {...params,mima:params.password}, })};
