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
import com.example.entity.Jianlitoudi;
import com.example.exception.CustomException;
import com.example.service.JianlitoudiService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.JianlitoudiVo;
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
@RequestMapping(value = "/jianlitoudi")
public class JianlitoudiController {

    @Resource
    private JianlitoudiService jianlitoudiService;

    @PostMapping
    public Result<Jianlitoudi> add(@RequestBody JianlitoudiVo jianlitoudi) {
		//yoxuxiaxnci
        jianlitoudiService.add(jianlitoudi);
        return Result.success(jianlitoudi);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("gangweimingcheng","Job Title");
        row.put("gongzuoshijian","working hours");
        row.put("qiyehao","Enterprise number");
        row.put("qiyemingcheng","The name of the business");
        row.put("fuzeren","Head");
        row.put("yonghuming","Username");
        row.put("xingming","name");
        row.put("shouji","phone");
        

        row.put("addtime","Add Time");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = jianlitoudiService.daochuexcel();
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
	
	@GetMapping("/jianlitoudi_tj_gangweimingcheng")
    public Result jianlitoudi_tj_gangweimingcheng() {
        return Result.success(jianlitoudiService.jianlitoudi_tj_gangweimingcheng());
    }
    

    @PostMapping("/deleteList")
    public Result<Jianlitoudi> deleteList(@RequestBody JianlitoudiVo jianlitoudi) {
        jianlitoudiService.deleteList(jianlitoudi.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        jianlitoudiService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody JianlitoudiVo jianlitoudi) {
        jianlitoudiService.update(jianlitoudi);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Jianlitoudi> detail(@PathVariable Integer id) {
        Jianlitoudi jianlitoudi = jianlitoudiService.findById(id);
        return Result.success(jianlitoudi);
    }

    @GetMapping
    public Result<List<Jianlitoudi>> all() {
        return Result.success(jianlitoudiService.list());
    }

    @PostMapping("/page")
    public Result<JianlitoudiVo> page(@RequestBody JianlitoudiVo jianlitoudiVo) {
        return Result.success(jianlitoudiService.findPage(jianlitoudiVo));
    }
	
	@PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws IOException {
        ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
        List<Jianlitoudi> jianlitoudis = reader.readAll(Jianlitoudi.class);
		
        jianlitoudiService.saveBatch(jianlitoudis);
        return Result.success();
    }
	
	//youupdt2login
}
