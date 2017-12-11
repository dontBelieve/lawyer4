package top.dongpeili.design.abstractFactory;

import top.dongpeili.design.factory.color.Color;
import top.dongpeili.design.factory.shape.Shape;

/**
 * @summary 抽象工厂
 * @date 2017年12月9日
 * @author dpl
 */
public abstract class AbstrctFactory {
	abstract Color getColor(Class<? extends Color> clazz);

	abstract Shape getShape(Class<? extends Shape> clazz);
}
