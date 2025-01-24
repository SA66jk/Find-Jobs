import request from '@/utils/request';
// list
export const jianlitoudiList = (params) => {
    return request({
        url: '/jianlitoudi/page',
        method: 'post',
        data: params,
    })
};
export const jianlitoudiDetail = (id) => {
    return request({
        url: '/jianlitoudi/'+id,
        method: 'get',
    })
};
// add
export const jianlitoudiSave = (params) => {
    return request({
        url: '/jianlitoudi',
        method: 'post',
        data: params,
    })
};
// updt
export const jianlitoudiEdit = (params) => {
    return request({
        url: '/jianlitoudi',
        method: 'put',
        data: params,
    })
};
// delete
export const jianlitoudiDelete = (id) => {
    return request({
        url: '/jianlitoudi/'+id,
        method: 'delete',
    })
};
// pldel
export const jianlitoudiDeleteList = (jianlitoudis) => {
    return request({
        url: '/jianlitoudi/deleteList',
        data:{list:jianlitoudis},
        method: 'post',
    })
};
// all
export const jianlitoudiAllList = () => {
    return request({
        url: '/jianlitoudi',
        method: 'get',
    })
};

export const jianlitoudi_tj_gangweimingcheng = () => {return request({url: '/jianlitoudi/jianlitoudi_tj_gangweimingcheng',method: 'get',})};