package top.dongpeili.design.Adapter;

import top.dongpeili.design.Adapter.intfc.AdvancedMediaPlayer;

public class VlcPlayer implements AdvancedMediaPlayer {
	@Override
	public void playVlc(String fileName) {
		System.out.println("Playing vlc file. Name: " + fileName);
	}

	@Override
	public void playMp4(String fileName) {
		// 什么也不做
	}
}