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
import com.example.entity.Jianlixinxi;
import com.example.exception.CustomException;
import com.example.service.JianlixinxiService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.JianlixinxiVo;
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
@RequestMapping(value = "/jianlixinxi")
public class JianlixinxiController {

    @Resource
    private JianlixinxiService jianlixinxiService;

    @PostMapping
    public Result<Jianlixinxi> add(@RequestBody JianlixinxiVo jianlixinxi) {
		//yoxuxiaxnci
        jianlixinxiService.add(jianlixinxi);
        return Result.success(jianlixinxi);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("jianlibianhao","Resume number");
        row.put("xingming","name");
        row.put("xingbie","gender");
        row.put("shouji","phone");
        row.put("zhuanye","specialized");
        row.put("gerenjianjie","Biography");
        row.put("yonghuming","Username");
        

        row.put("addtime","Add Time");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = jianlixinxiService.daochuexcel();
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
    public Result<Jianlixinxi> deleteList(@RequestBody JianlixinxiVo jianlixinxi) {
        jianlixinxiService.deleteList(jianlixinxi.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        jianlixinxiService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody JianlixinxiVo jianlixinxi) {
        jianlixinxiService.update(jianlixinxi);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Jianlixinxi> detail(@PathVariable Integer id) {
        Jianlixinxi jianlixinxi = jianlixinxiService.findById(id);
        return Result.success(jianlixinxi);
    }

    @GetMapping
    public Result<List<Jianlixinxi>> all() {
        return Result.success(jianlixinxiService.list());
    }

    @PostMapping("/page")
    public Result<JianlixinxiVo> page(@RequestBody JianlixinxiVo jianlixinxiVo) {
        return Result.success(jianlixinxiService.findPage(jianlixinxiVo));
    }
	
	@PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws IOException {
        ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
        List<Jianlixinxi> jianlixinxis = reader.readAll(Jianlixinxi.class);
		
        jianlixinxiService.saveBatch(jianlixinxis);
        return Result.success();
    }
	
	//youupdt2login
}
