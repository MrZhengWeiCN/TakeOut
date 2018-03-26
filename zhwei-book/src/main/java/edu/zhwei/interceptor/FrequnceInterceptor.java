package edu.zhwei.interceptor;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import edu.zhwei.component.JedisClient;

/**
 * 实现频率控制
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * github:
 * </p>
 * 
 * @date 2018-3-26 上午9:53:52
 * @author Zhwei
 */
public class FrequnceInterceptor implements HandlerInterceptor {

	@Autowired
	private JedisClient jedisClient;

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {
		// 去redis那里统计频率，ip————frequnt
		// 获得ip地址
		// 放置IP地址獲得代理服務器的地址
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			ip = ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
			if (ip.equals("127.0.0.1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ip = inet.getHostAddress();
			}
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ip != null && ip.length() > 15) {
			if (ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
			}
		}
		// 去redis查询
		String ip_Frequnt = jedisClient.get(ip);
		if (ip_Frequnt == null) {
			jedisClient.incr(ip);
			jedisClient.expire(ip, 5);
			return true;
		} else {
			Integer frequent = Integer.valueOf(ip_Frequnt);
			jedisClient.incr(ip);
			if (frequent >= 10) {
				response.sendRedirect("/frequentError");
				return false;
			} else {
				return true;
			}
		}
	}
}
