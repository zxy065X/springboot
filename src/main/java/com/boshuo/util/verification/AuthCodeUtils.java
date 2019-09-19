package com.boshuo.util.verification;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author ：zhangxy
 * @date ：Created in 2019/8/26 14:09
 * @description：图片验证码
 * @modified By：
 * @version: 1.0$
 */
public class AuthCodeUtils {

    private static int width = 90;// 定义图片的width
    private static int height = 20;// 定义图片的height
    private static int codeCount = 4;// 定义图片上显示验证码的个数
    private static int xx = 15;
    private static int fontHeight = 18;
    private static int codeY = 16;
    private static char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * create by: zhangxy
     * description: TODO
     * create time: 2019/8/26 14:14
     *
     * @return
     * @Param: null
     */
    public static Map<String, Object> getCodeAndpic() {
        //定义buffer图像
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics graphics = image.getGraphics();
        //创建随机生成器
        Random random = new Random();
        //将图像填充成白色
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);

        //设置字体样式
        Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
        graphics.setFont(font);

        //设置边框
        graphics.setColor(Color.BLACK);
        graphics.drawLine(0, 0, width - 1, height - 1);

        //生成干扰线
        for (int i = 0; i < 30; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            graphics.drawLine(x, y, x + xl, y + yl);
        }

        StringBuffer buffer = new StringBuffer();
        int red = 0, green = 0, blue = 0;
        for (int i = 0; i < codeCount; i++) {
            //得到随机生成的数
            String code = String.valueOf(codeSequence[random.nextInt(36)]);
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            graphics.setColor(new Color(red,green,blue));
            graphics.drawString(code,(i+1)*xx,codeY);
            buffer.append(code);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",buffer);
        map.put("codePic",image);
        return map;
    }

    /**验证验证码
     * create by: zhangxy
     * description: TODO
     * create time: 2019/8/26 14:57
     *
      * @Param: null
     * @return
     */
    public static boolean checkCode(HttpServletRequest request, HttpServletResponse response){
        String code = request.getParameter("code");
        String sessionCode = request.getSession().getAttribute("code").toString();
        if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(sessionCode)){
            if (code.equalsIgnoreCase(sessionCode)){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

}
