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
import com.example.entity.Gangweixinxi;
import com.example.exception.CustomException;
import com.example.service.GangweixinxiService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.GangweixinxiVo;
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
@RequestMapping(value = "/gangweixinxi")
public class GangweixinxiController {

    @Resource
    private GangweixinxiService gangweixinxiService;

    @PostMapping
    public Result<Gangweixinxi> add(@RequestBody GangweixinxiVo gangweixinxi) {
		//yoxuxiaxnci
        gangweixinxiService.add(gangweixinxi);
        return Result.success(gangweixinxi);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("gangweimingcheng","Job Title");
        row.put("gongzuodidian","Place of work");
        row.put("gongzuoshijian","working hours");
        row.put("xuqiurenshu","Number of people required");
        row.put("xinzi","Salary");
        row.put("gangweimiaoshu","Job Description:");
        row.put("qiyehao","Enterprise number");
        row.put("qiyemingcheng","The name of the business");
        row.put("fuzeren","Head");
        row.put("lianxidianhua","Contact number");
        

        row.put("addtime","Add Time");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = gangweixinxiService.daochuexcel();
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
    public Result<Gangweixinxi> deleteList(@RequestBody GangweixinxiVo gangweixinxi) {
        gangweixinxiService.deleteList(gangweixinxi.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        gangweixinxiService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody GangweixinxiVo gangweixinxi) {
        gangweixinxiService.update(gangweixinxi);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Gangweixinxi> detail(@PathVariable Integer id) {
        Gangweixinxi gangweixinxi = gangweixinxiService.findById(id);
        return Result.success(gangweixinxi);
    }

    @GetMapping
    public Result<List<Gangweixinxi>> all() {
        return Result.success(gangweixinxiService.list());
    }

    @PostMapping("/page")
    public Result<GangweixinxiVo> page(@RequestBody GangweixinxiVo gangweixinxiVo) {
        return Result.success(gangweixinxiService.findPage(gangweixinxiVo));
    }
	
	@PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws IOException {
        ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
        List<Gangweixinxi> gangweixinxis = reader.readAll(Gangweixinxi.class);
		
        gangweixinxiService.saveBatch(gangweixinxis);
        return Result.success();
    }
	
	//youupdt2login
}
