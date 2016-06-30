package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig {
	private int width;
	private int height;
	private int windowSize;
	private int padding;
	
	private List<LayerConfig> layersConfig;
	
	public GameConfig() throws Exception{
		SAXReader reader=new SAXReader();
		Document doc=reader.read("config/cfg.xml");
		//获得XML文件的根节点
		Element game=doc.getRootElement();
		//配置窗口参数
		this.setUiConfig(game.element("frame"));
		//配置系统参数
		this.setSystemConfig(game.element("frame"));
		//配置数据访问参数
		this.setDataConfig(game.element("data"));
	}
	
	/**
	 * 配置窗口
	 * @param frame 配置文件的窗口配置元素
	 */
	private void setUiConfig(Element frame){
		//获取窗口宽度
		this.width=Integer.parseInt(frame.attributeValue("width"));
		//获取窗口高度
		this.height=Integer.parseInt(frame.attributeValue("height"));
		//获取边框粗细
		this.windowSize=Integer.parseInt(frame.attributeValue("windowSize"));
		//获取边框内边距
		this.padding=Integer.parseInt(frame.attributeValue("padding"));
		//获取标题
		this.title=frame.attributeValue("title");
		//获取窗口拔高
		this.windowUp=Integer.parseInt(frame.attributeValue("windowUp"));
		//获取窗体属性
		List<Element> layers=frame.elements("layer");
		layersConfig=new ArrayList<LayerConfig>();
		for(Element layer:layers){
			LayerConfig lc=new LayerConfig(
					layer.attributeValue("className"),
					Integer.parseInt(layer.attributeValue("x")),
					Integer.parseInt(layer.attributeValue("y")),
					Integer.parseInt(layer.attributeValue("w")),
					Integer.parseInt(layer.attributeValue("h"))
			);
			layersConfig.add(lc);
			
		}
	}
	
	public String getTitle() {
		return title;
	}

	public int getWindowUp() {
		return windowUp;
	}

	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 窗口拔高
	 */
	private int windowUp;
	
	/**
	 * 配置系统参数
	 * @param frame
	 */
	private void setSystemConfig(Element frame){
		
	}
	
	/**
	 * 配置数据访问参数
	 * @param data
	 */
	private void setDataConfig(Element data){
		
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getWindowSize() {
		return windowSize;
	}

	public int getPadding() {
		return padding;
	}

	public List<LayerConfig> getLayersConfig() {
		return layersConfig;
	}
	
	
}
