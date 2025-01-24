import request from '@/utils/request';
// list
export const xiaoxitongzhiList = (params) => {
    return request({
        url: '/xiaoxitongzhi/page',
        method: 'post',
        data: params,
    })
};
export const xiaoxitongzhiDetail = (id) => {
    return request({
        url: '/xiaoxitongzhi/'+id,
        method: 'get',
    })
};
// add
export const xiaoxitongzhiSave = (params) => {
    return request({
        url: '/xiaoxitongzhi',
        method: 'post',
        data: params,
    })
};
// updt
export const xiaoxitongzhiEdit = (params) => {
    return request({
        url: '/xiaoxitongzhi',
        method: 'put',
        data: params,
    })
};
// delete
export const xiaoxitongzhiDelete = (id) => {
    return request({
        url: '/xiaoxitongzhi/'+id,
        method: 'delete',
    })
};
// pldel
export const xiaoxitongzhiDeleteList = (xiaoxitongzhis) => {
    return request({
        url: '/xiaoxitongzhi/deleteList',
        data:{list:xiaoxitongzhis},
        method: 'post',
    })
};
// all
export const xiaoxitongzhiAllList = () => {
    return request({
        url: '/xiaoxitongzhi',
        method: 'get',
    })
};

