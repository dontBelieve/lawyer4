package top.dongpeili.design.abstractFactory;

import top.dongpeili.design.factory.color.Color;
import top.dongpeili.design.factory.shape.Shape;

/**
 * @summary 实现了抽象工厂的形状工厂
 * @date 2017年12月10日
 * @author dpl
 */
public class ShapeFactory extends AbstrctFactory {

	@Override
	Color getColor(Class<? extends Color> clazz) {
		return null;
	}

	@Override
	Shape getShape(Class<? extends Shape> clazz) {
		Object obj = null;
		try {
			obj = Class.forName(clazz.getName()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return (Shape) obj;
	}

}
