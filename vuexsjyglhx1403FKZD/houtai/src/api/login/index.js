import request from '@/utils/request';

export const login =(params) => {
	if(params.role == 'Admin'){return request({url: '/guanliyuan/login',method: 'post',data: {yonghuming:params.username,mima:params.password},});}
	else if(params.role == 'enterprise'){return request({url: '/qiyexinxi/login',method: 'post',data: {qiyehao:params.username,mima:params.password},});}
else if(params.role == 'Job Seekers'){return request({url: '/yonghuxinxi/login',method: 'post',data: {yonghuming:params.username,mima:params.password},});}

	
	
}
export const register =(params) => {return request({url: '/yonghuxinxi/register',method: 'post',data: {yonghuming:params.username,mima:params.password},})}