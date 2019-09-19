package com.boshuo.contorller;

import java.io.File;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.boshuo.config.SystemConfig;
import com.boshuo.util.ConstantUtil;
import com.boshuo.util.DateUtils;
import com.boshuo.util.ResponseUtil;
import com.boshuo.util.dto.DataResult;

@Controller
@RequestMapping("file")
public class FileContorller {

	private static final Logger logger = LoggerFactory.getLogger(FileContorller.class);

	@PostConstruct
	public void init() {
		String path = this.getClass().getResource("/").getPath();
		if (path.indexOf("target") != -1) {
			SystemConfig.FILE_PATH = path.replace("target/classes/", "file/");
		} else {
			SystemConfig.FILE_PATH = path.replace("resources/", "file/");
		}
		File dist = new File(SystemConfig.FILE_PATH);
		// 如果文件夹不存在则创建
		if (!dist.exists() && !dist.isDirectory()) {
			dist.mkdir();
		}
		logger.info("FILE_PATH:" + SystemConfig.FILE_PATH);
	}

	@PostMapping("/uploadFile")
	@ResponseBody
	public DataResult uploadFile(@RequestParam("fileName") MultipartFile file) {

		if (file.isEmpty()) {
			return DataResult.build250("请选择上传文件");
		}
		// 获取文件名
		String originalName = file.getOriginalFilename();
		logger.info("上传的文件名为：" + originalName);

		// 获取文件的后缀名
		String suffixName = originalName.substring(originalName.lastIndexOf("."));

		// 为文件取新的名字
		String newName = System.currentTimeMillis() + ConstantUtil.gencode(8) + suffixName;

		// 新文件保存路径
		String savepath = DateUtils.formatD(new Date()) + "/" + newName;

		// 创建新文件
		File newfile = new File(SystemConfig.FILE_PATH + savepath);
		// 检测是否存在目录
		if (!newfile.getParentFile().exists()) {
			newfile.getParentFile().mkdirs();
		}
		try {
			file.transferTo(newfile);
			// 下一步是保存路径到数据库
			return null;
		} catch (Exception e) {
			logger.error("uploadFile", e);
			return DataResult.build500();
		}

	}

	@GetMapping("readImg/{hashCode}/{height}/{width}")
	public void readImg(HttpServletResponse response, @PathVariable String hashCode, @PathVariable Integer height,
			@PathVariable Integer width) {

	}

//	@GetMapping("readFile/{hashCode}")
//	public void readFile(HttpServletResponse response, @PathVariable String hashCode) {
//
//		if (StringUitl.isEmpty(hashCode)) {
//			return;
//		}
//		String filePath;
//		try {
//			filePath = fileService.readfile(hashCode);
//		} catch (Exception e) {
//			logger.error("readFile", e);
//			return;
//		}
//		if (StringUitl.isEmpty(filePath)) {
//			return;
//		}
//		File file = new File(SystemConfig.FILE_PATH + filePath);
//		ResponseUtil.readFileResponse(response, file);
//
//	}
//
//	@GetMapping("noThroughDownload/{hashCode}")
//	public void download(HttpServletResponse response, @PathVariable String hashCode) {
//		try {
//			if (StringUitl.isEmpty(hashCode)) {
//				return;
//			}
//			String filePath = fileService.readfile(hashCode);
//			if (StringUitl.isEmpty(filePath)) {
//				return;
//			}
//			ResponseUtil.download(SystemConfig.FILE_PATH + filePath, response);
//		} catch (Exception e) {
//			logger.error("readFile", e);
//		}
//	}

	@GetMapping("templateDownload")
	public void download(HttpServletResponse response) {
		try {
			ResponseUtil.download(SystemConfig.FILE_PATH + "任务模板.xlsx", response);
		} catch (Exception e) {
			logger.error("templateDownload", e);
		}
	}

}
