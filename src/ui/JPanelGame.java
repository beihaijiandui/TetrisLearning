package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import config.ConfigFactory;
import config.GameConfig;
import config.LayerConfig;

public class JPanelGame extends JPanel{
	
	private List<Layer> layers=null;
	
	public JPanelGame(){
	try {
		//�����Ϸ����
		GameConfig cfg=ConfigFactory.getGameConfig();
		//��ò�����
		List<LayerConfig> layersCfg=cfg.getLayersConfig();
		//������Ϸ������
		layers=new ArrayList<Layer>(layersCfg.size());
		//�������в����
		for(LayerConfig layerCfg:layersCfg){
			//��������
			Class<?> cls=Class.forName(layerCfg.getClassName());
			//��ù��캯��
			Constructor ctr=cls.getConstructor(int.class,int.class,int.class,int.class);
			//���ù��캯����������
			Layer l=(Layer)ctr.newInstance(
					layerCfg.getX(),layerCfg.getY(),layerCfg.getW(),layerCfg.getH()
			);
			//�Ѵ�����layer������뼯��
			layers.add(l);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
/*		lays=new Layer[]{
				new LayerBackground(0,0,0,0),//�⼸������ʵ����û���õ� ��������ѡ��0 0 0 0
				new LayerDataBase(40,32,334,279),
				new LayerDisk(40,343,334,279),
				new LayerGame(414,32,334,590),
				new LayerButton(788,32,334,124),
				new LayerNext(788,188,176,148),
				new LayerLevel(964,188,158,148),
				new LayerPoint(788,368,334,200),
		};*/
	}
	
	@Override
	//Graphics�ǻ���
	public void paintComponent(Graphics g){
		//������Ϸ����
		for(int i=0;i<layers.size();i++){
			layers.get(i).paint(g);
		}
		
//		g.drawImage(image, 32, 32, null);
//		g.drawImage(image,0,0,1024,1024,0,0,655,655,null);
	}
}
