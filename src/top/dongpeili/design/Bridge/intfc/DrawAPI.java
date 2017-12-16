package top.dongpeili.design.Bridge.intfc;

/**
 * @summary 画画的接口
 * @date 2017年12月16日
 * @author dpl
 */
public interface DrawAPI {

	/**
	 * @summary 画圆, 入参半径和原点
	 * @date 2017年12月16日
	 * @return void
	 * @author dpl
	 */
	public void drawCircle(int radius, int x, int y);
}
