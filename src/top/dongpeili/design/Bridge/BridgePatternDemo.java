package top.dongpeili.design.Bridge;

/**
 * @summary 桥接模式测试. 跑尸能跑, 跟桥接模式有个毛关系啊 
 * 			会写, 但是不明白有什么意义
 * @date 2017年12月16日
 * @author dpl
 */
public class BridgePatternDemo {
	public static void main(String[] args) {
		Shape redCircle = new Circle(100, 100, 10, new RedCircle());
		Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

		redCircle.draw();
		greenCircle.draw();
	}
}
