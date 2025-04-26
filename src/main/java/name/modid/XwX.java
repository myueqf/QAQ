package name.modid;
// 包名不知道叫什么好听捏。。。。就先用默认叭～
import net.fabricmc.api.ModInitializer;

public class XwX implements ModInitializer {
	@Override
	public void onInitialize() {
		// 初始化功能
		new JetpackHandler();
		new FallDamagePreventer();
	}
}