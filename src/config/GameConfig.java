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
		//���XML�ļ��ĸ��ڵ�
		Element game=doc.getRootElement();
		//���ô��ڲ���
		this.setUiConfig(game.element("frame"));
		//����ϵͳ����
		this.setSystemConfig(game.element("frame"));
		//�������ݷ��ʲ���
		this.setDataConfig(game.element("data"));
	}
	
	/**
	 * ���ô���
	 * @param frame �����ļ��Ĵ�������Ԫ��
	 */
	private void setUiConfig(Element frame){
		//��ȡ���ڿ��
		this.width=Integer.parseInt(frame.attributeValue("width"));
		//��ȡ���ڸ߶�
		this.height=Integer.parseInt(frame.attributeValue("height"));
		//��ȡ�߿��ϸ
		this.windowSize=Integer.parseInt(frame.attributeValue("windowSize"));
		//��ȡ�߿��ڱ߾�
		this.padding=Integer.parseInt(frame.attributeValue("padding"));
		//��ȡ����
		this.title=frame.attributeValue("title");
		//��ȡ���ڰθ�
		this.windowUp=Integer.parseInt(frame.attributeValue("windowUp"));
		//��ȡ��������
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
	 * ����
	 */
	private String title;
	
	/**
	 * ���ڰθ�
	 */
	private int windowUp;
	
	/**
	 * ����ϵͳ����
	 * @param frame
	 */
	private void setSystemConfig(Element frame){
		
	}
	
	/**
	 * �������ݷ��ʲ���
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
