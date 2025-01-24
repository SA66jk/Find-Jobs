package com.example.controller;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.Result;
import com.example.common.ResultCode;
import com.example.entity.Qiyexinxi;
import com.example.exception.CustomException;
import com.example.service.QiyexinxiService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.QiyexinxiVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import cn.hutool.poi.excel.ExcelReader;
import org.springframework.web.multipart.MultipartFile;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/qiyexinxi")
public class QiyexinxiController {

    @Resource
    private QiyexinxiService qiyexinxiService;

    @PostMapping
    public Result<Qiyexinxi> add(@RequestBody QiyexinxiVo qiyexinxi) {
		//yoxuxiaxnci
        qiyexinxiService.add(qiyexinxi);
        return Result.success(qiyexinxi);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("qiyehao","Enterprise number");
        row.put("qiyemingcheng","The name of the business");
        row.put("qiyedizhi","Business address");
        row.put("fuzeren","Head");
        row.put("lianxidianhua","Contact number");
        row.put("qiyejianjie","Company Profile");
        

        row.put("addtime","Add Time");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = qiyexinxiService.daochuexcel();
        for (Map<String, Object> map : daochuexcellist) {
            list.add(map);
        }
        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=chaoba.xlsx");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(System.out);
    }
	
	

    @PostMapping("/deleteList")
    public Result<Qiyexinxi> deleteList(@RequestBody QiyexinxiVo qiyexinxi) {
        qiyexinxiService.deleteList(qiyexinxi.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        qiyexinxiService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody QiyexinxiVo qiyexinxi) {
        qiyexinxiService.update(qiyexinxi);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Qiyexinxi> detail(@PathVariable Integer id) {
        Qiyexinxi qiyexinxi = qiyexinxiService.findById(id);
        return Result.success(qiyexinxi);
    }

    @GetMapping
    public Result<List<Qiyexinxi>> all() {
        return Result.success(qiyexinxiService.list());
    }

    @PostMapping("/page")
    public Result<QiyexinxiVo> page(@RequestBody QiyexinxiVo qiyexinxiVo) {
        return Result.success(qiyexinxiService.findPage(qiyexinxiVo));
    }
	
	@PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws IOException {
        ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
        List<Qiyexinxi> qiyexinxis = reader.readAll(Qiyexinxi.class);
		for (Qiyexinxi qiyexinxi : qiyexinxis) { qiyexinxi.setMima("dc5c7986daef50c1e02ab09b442ee34f");}
        qiyexinxiService.saveBatch(qiyexinxis);
        return Result.success();
    }
	
	    @PostMapping("/login")
    public Result login(@RequestBody Qiyexinxi qiyexinxi, HttpServletRequest request) {
        if (StrUtil.isBlank(qiyexinxi.getQiyehao()) || StrUtil.isBlank(qiyexinxi.getMima())) {
            throw new CustomException(ResultCode.PARAM_LOST_ERROR);
        }
        Qiyexinxi login = qiyexinxiService.login(qiyexinxi);
//        if(!login.getStatus()){
//            return Result.error("1001","状态限制，无法login系统");
//        }
        if(login != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("user", login);
            Map<String, Object> map = MapWrapperUtils.builder(MapWrapperUtils.KEY_USER_ID,qiyexinxi.getId());
            String token = JwtUtil.creatToken(map);
            hashMap.put("token", token);
            return Result.success(hashMap);
        }else {
            return Result.error();
        }
    }
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Qiyexinxi info, HttpServletRequest request) {
        Qiyexinxi qiyexinxi = qiyexinxiService.findById(info.getId());
        String oldPassword = SecureUtil.md5(info.getMima());
        if (!oldPassword.equals(qiyexinxi.getMima())) {
            return Result.error(ResultCode.PARAM_PASSWORD_ERROR.code, ResultCode.PARAM_PASSWORD_ERROR.msg);
        }
        info.setMima(SecureUtil.md5(info.getNewPassword()));
        Qiyexinxi qiyexinxi1 = new Qiyexinxi();
        BeanUtils.copyProperties(info, qiyexinxi1);
        qiyexinxiService.update(qiyexinxi1);
        return Result.success();
    }
	@PostMapping("/register")
    public Result<Qiyexinxi> register(@RequestBody QiyexinxiVo qiyexinxi) {
        qiyexinxiService.add(qiyexinxi);
        return Result.success(qiyexinxi);
    }
}
