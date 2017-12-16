package top.dongpeili.design.Bridge;

import top.dongpeili.design.Bridge.intfc.DrawAPI;

/**
 * @summary 绿圆实体类, 实现画画接口
 * @date 2017年12月16日
 * @author dpl
 */
public class GreenCircle implements DrawAPI {
	@Override
	public void drawCircle(int radius, int x, int y) {
		System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
	}
}
