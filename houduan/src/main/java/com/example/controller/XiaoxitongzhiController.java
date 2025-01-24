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
import com.example.entity.Xiaoxitongzhi;
import com.example.exception.CustomException;
import com.example.service.XiaoxitongzhiService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.XiaoxitongzhiVo;
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
@RequestMapping(value = "/xiaoxitongzhi")
public class XiaoxitongzhiController {

    @Resource
    private XiaoxitongzhiService xiaoxitongzhiService;

    @PostMapping
    public Result<Xiaoxitongzhi> add(@RequestBody XiaoxitongzhiVo xiaoxitongzhi) {
		//yoxuxiaxnci
        xiaoxitongzhiService.add(xiaoxitongzhi);
        return Result.success(xiaoxitongzhi);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("gangweimingcheng","Job Title");
        row.put("yonghuming","Username");
        row.put("xingming","name");
        row.put("biaoti","Title");
        row.put("neirong","content");
        row.put("tongzhishijian","Notification time");
        row.put("qiyehao","Enterprise number");
        row.put("fuzeren","Head");
        row.put("lianxidianhua","Contact number");
        

        row.put("addtime","Add Time");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = xiaoxitongzhiService.daochuexcel();
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
    public Result<Xiaoxitongzhi> deleteList(@RequestBody XiaoxitongzhiVo xiaoxitongzhi) {
        xiaoxitongzhiService.deleteList(xiaoxitongzhi.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        xiaoxitongzhiService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody XiaoxitongzhiVo xiaoxitongzhi) {
        xiaoxitongzhiService.update(xiaoxitongzhi);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Xiaoxitongzhi> detail(@PathVariable Integer id) {
        Xiaoxitongzhi xiaoxitongzhi = xiaoxitongzhiService.findById(id);
        return Result.success(xiaoxitongzhi);
    }

    @GetMapping
    public Result<List<Xiaoxitongzhi>> all() {
        return Result.success(xiaoxitongzhiService.list());
    }

    @PostMapping("/page")
    public Result<XiaoxitongzhiVo> page(@RequestBody XiaoxitongzhiVo xiaoxitongzhiVo) {
        return Result.success(xiaoxitongzhiService.findPage(xiaoxitongzhiVo));
    }
	
	@PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws IOException {
        ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
        List<Xiaoxitongzhi> xiaoxitongzhis = reader.readAll(Xiaoxitongzhi.class);
		
        xiaoxitongzhiService.saveBatch(xiaoxitongzhis);
        return Result.success();
    }
	
	//youupdt2login
}
