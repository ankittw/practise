package adap.asset.functionality;

import java.awt.Color;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.UnknownHostException;

import testGUI.AdapsMainGui;

import adap.asset.mainApplication.ADAPSMain;
import adap.asset.radar.DisplayRadarCoverage;
import adap.asset.radar.SaveUpdateDB;

import com.esri.arcgis.analyst3d.IGraphicsContainer3D;
import com.esri.arcgis.analyst3d.ILine3DPlacement;
import com.esri.arcgis.analyst3d.IRasterSurface;
import com.esri.arcgis.analyst3d.IScene;
import com.esri.arcgis.analyst3d.ISimpleLine3DSymbol;
import com.esri.arcgis.analyst3d.RasterSurface;
import com.esri.arcgis.analyst3d.SimpleLine3DSymbol;
import com.esri.arcgis.analyst3d.SimpleMarker3DSymbol;
import com.esri.arcgis.analyst3d.esriSimple3DLineStyle;
import com.esri.arcgis.analyst3d.esriSimple3DMarkerStyle;
import com.esri.arcgis.carto.FeatureLayer;
import com.esri.arcgis.carto.GroupLayer;
import com.esri.arcgis.carto.IElement;
import com.esri.arcgis.carto.IEnumLayer;
import com.esri.arcgis.carto.IFeatureLayer;
import com.esri.arcgis.carto.IGraphicsContainer;
import com.esri.arcgis.carto.ILayer;
import com.esri.arcgis.carto.ILayerEffects;
import com.esri.arcgis.carto.ILineElement;
import com.esri.arcgis.carto.IMarkerElement;
import com.esri.arcgis.carto.IRasterClassifyColorRampRenderer;
import com.esri.arcgis.carto.IRasterLayer;
import com.esri.arcgis.carto.LineElement;
import com.esri.arcgis.carto.MarkerElement;
import com.esri.arcgis.carto.PictureElement;
import com.esri.arcgis.carto.RasterLayer;
import com.esri.arcgis.controls.GlobeHookHelper;
import com.esri.arcgis.controls.HookHelper;
import com.esri.arcgis.controls.IGlobeHookHelper;
import com.esri.arcgis.controls.MissingCommand;
import com.esri.arcgis.datasourcesGDB.FileGDBScratchWorkspaceFactory;
import com.esri.arcgis.datasourcesGDB.FileGDBWorkspaceFactory;
import com.esri.arcgis.datasourcesraster.IRasterBandCollection;
import com.esri.arcgis.datasourcesraster.IRasterBandCollectionProxy;
import com.esri.arcgis.datasourcesraster.IRasterWorkspace;
import com.esri.arcgis.datasourcesraster.RasterWorkspaceFactory;
import com.esri.arcgis.display.IColor;
import com.esri.arcgis.display.ILineSymbol;
import com.esri.arcgis.display.IMarkerSymbol;
import com.esri.arcgis.display.IPictureMarkerSymbol;
import com.esri.arcgis.display.IRgbColor;
import com.esri.arcgis.display.PictureMarkerSymbol;
import com.esri.arcgis.display.RgbColor;
import com.esri.arcgis.display.esriIPictureType;
import com.esri.arcgis.geodatabase.Feature;
import com.esri.arcgis.geodatabase.FeatureClassDescription;
import com.esri.arcgis.geodatabase.Field;
import com.esri.arcgis.geodatabase.Fields;
import com.esri.arcgis.geodatabase.GeometryDef;
import com.esri.arcgis.geodatabase.ICursor;
import com.esri.arcgis.geodatabase.IDataset;
import com.esri.arcgis.geodatabase.IDatasetName;
import com.esri.arcgis.geodatabase.IEnumDataset;
import com.esri.arcgis.geodatabase.IEnumDatasetName;
import com.esri.arcgis.geodatabase.IFeature;
import com.esri.arcgis.geodatabase.IFeatureClass;
import com.esri.arcgis.geodatabase.IFeatureClassDescription;
import com.esri.arcgis.geodatabase.IFeatureWorkspace;
import com.esri.arcgis.geodatabase.IFeatureWorkspaceProxy;
import com.esri.arcgis.geodatabase.IField;
import com.esri.arcgis.geodatabase.IFieldEdit;
import com.esri.arcgis.geodatabase.IFields;
import com.esri.arcgis.geodatabase.IFieldsEdit;
import com.esri.arcgis.geodatabase.IGeometryDef;
import com.esri.arcgis.geodatabase.IGeometryDefEdit;
import com.esri.arcgis.geodatabase.IObjectClassDescription;
import com.esri.arcgis.geodatabase.IRaster;
import com.esri.arcgis.geodatabase.IRasterDataset;
import com.esri.arcgis.geodatabase.IRow;
import com.esri.arcgis.geodatabase.ISurface;
import com.esri.arcgis.geodatabase.IWorkspace;
import com.esri.arcgis.geodatabase.IWorkspaceEdit;
import com.esri.arcgis.geodatabase.IWorkspaceFactory;
import com.esri.arcgis.geodatabase.Workspace;
import com.esri.arcgis.geodatabase.WorkspaceEditEvents;
import com.esri.arcgis.geodatabase.esriDatasetType;
import com.esri.arcgis.geodatabase.esriFeatureType;
import com.esri.arcgis.geodatabase.esriFieldType;
import com.esri.arcgis.geometry.ICircularArc;
import com.esri.arcgis.geometry.IGeometry;
import com.esri.arcgis.geometry.IGeometryCollection;
import com.esri.arcgis.geometry.IPoint;
import com.esri.arcgis.geometry.IPointCollection;
import com.esri.arcgis.geometry.IPolyline;
import com.esri.arcgis.geometry.IRing;
import com.esri.arcgis.geometry.ISpatialReference;
import com.esri.arcgis.geometry.IVector3D;
import com.esri.arcgis.geometry.IZAware;
import com.esri.arcgis.geometry.MultiPatch;
import com.esri.arcgis.geometry.Point;
import com.esri.arcgis.geometry.Polyline;
import com.esri.arcgis.geometry.Ring;
import com.esri.arcgis.geometry.Vector3D;
import com.esri.arcgis.geometry.esriGeometryType;
import com.esri.arcgis.geoprocessing.tools.datamanagementtools.GetCount;
import com.esri.arcgis.globecore.GlobeGraphicsLayer;
import com.esri.arcgis.globecore.IGlobe;
import com.esri.arcgis.globecore.IGlobeDisplayLayers2;
import com.esri.arcgis.globecore.esriGlobeLayerType;
import com.esri.arcgis.interop.AutomationException;
import com.esri.arcgis.support.ms.stdole.IPicture;
import com.esri.arcgis.system.Array;
import com.esri.arcgis.system.UID;
import com.esri.arcgis.system.esriCoreErrorReturnCodes;
import com.esri.arcgis.system.esriUnits;
import com.esri.arcgis.systemUI.esriArcGISUri;

	public class CreateRadarRings {
		
		public void createRadar(String ID,String Type,Double xLat, Double xLong, String RdrID, Double elevVal,String displayType) {
			
		
		try {
			
			IGraphicsContainer3D outlineGraphicsContainer3D = new GlobeGraphicsLayer();
			//calls to get layer
			IFeatureLayer graphicsContainer3D = ADAPSUtil.getLayer("FeatureLayer");
			
			if(graphicsContainer3D==null) return;
			
			
			
			Double circleDiv = 36.00;
			Double circleDeg = 360.00;
			Double elevHeight = elevVal;   // From Height TextBox
			Double rads = getRadian(circleDeg/circleDiv);
			
			String layerPath= ((ADAPSMain.getElevationLayerPath()).get(ADAPSMain.getCurrentElevationLayer())).toString();
			IRasterLayer rasterLayer = new RasterLayer();
			//change request

//			rasterLayer.createFromFilePath("/opt/GEODB/ada/43J11.dt2");
			rasterLayer.createFromFilePath(layerPath);
			System.out.println(rasterLayer.getBandCount());
		
			IRasterSurface rasterSurface = new RasterSurface();
			rasterSurface.putRaster(rasterLayer.getRaster(), 0);
			ISurface surface = (ISurface) rasterSurface;
	
			IPoint point = new Point();
			point.setX(xLat);
			point.setY(xLong);
			
			
			double ht = surface.getElevation(point);
			System.out.println("Elevation : " + ht);
			point.setZ(elevHeight+ht);
			IZAware zAware = (IZAware)point;
			zAware.setZAware(true);
			
			ILayer symLyr = displaySymbol(xLat,xLong,point);
			
			IVector3D upperVector3D = new Vector3D();
			upperVector3D.setComponents(0, 0, 10);
	
			IVector3D dupLowerVector3D = new Vector3D();
			dupLowerVector3D.setComponents(1, 0, 0);
	
			IVector3D lowerVector3D = new Vector3D();
			lowerVector3D.setComponents(0, 0, -10);
			
			Double offsetVal = 0.00001;
			lowerVector3D.setXComponent(lowerVector3D.getXComponent()+offsetVal);
			IVector3D normalVector3D = (IVector3D) upperVector3D.crossProduct(lowerVector3D);
			IVector3D dupNormalVector3D = (IVector3D) upperVector3D.crossProduct(lowerVector3D);
			
	// Create Apex Point
			IPoint apexPoint = new Point();
			IZAware apexZAware = (IZAware) apexPoint;
			
			
			apexPoint = ADAPSUtil.constructPoint3d(point.getX(), point.getY(), point.getZ());
			apexZAware.setZAware(true);
			normalVector3D.normalize();
			
			
			//MaterInfo2 for height vales
	//		String height ="51567,25784,18146,14613,10890,10031,7863,7885,6054,5048,4695,4162,3798,3569,3256,3090,2841,2717,2424,2361,1509,1965,1705,1563,1432,1445,1285,1137,1058,1005,898,907,810,821,732,680,725,645,643,571,586,477,454,431,409,389,369";
	//		String[] heightArr = height.split(",");
	
			
			String[] heightArr = retrieveARHData(Type+"_"+ID,"Height");
			
			//countRow and countColumn are the
			/**Masterinfo3
			 * for Range Coloum in Polar Entry
			 */

			
			
	//		String Rng = "0.5,1,1.5,2,2.5,3,3.5,4,4.5,5,5.5,6,6.5,7,7.5,8,8.5,9,9.5,10,10.5,11,11.5,12,12.5,13,13.5,14,14.5,15,15.5,16,16.5,17,17.5,18,18.5,19,20,20.5,21,21.5,360,22.5,23,23.5,24";
	//		String[] arrAngle= Rng.split(",");
	
			String[] arrAngle= retrieveARHData(Type+"_"+ID,"Angle");
			int horizontal, vertical;
			IPointCollection pointCol;
			IPoint surfacePt = new Point();
			IRing ringColl;
			IGeometryCollection geoColl;
		
			
			/*******Change this to add your own range instead of retrieving from DB**********/
			
			String Range = "10,20,30,40,50,60,70,80,90,100";
			String[] arrRng= Range.split(",");
			
			//String[] arrRng= retrieveARHData(Type+"_"+ID,"Range");
			double minusValFirst, minusValSecond, minusValThird;
			
			IPoint obstaclePoint = new Point() ;
			geoColl = new MultiPatch();
			for(vertical =0; vertical <= arrRng.length-1;vertical++){
			//for(vertical =0; vertical <= arrRng.length-2;vertical++){
				pointCol = new Ring();
				minusValFirst =Double.parseDouble(arrAngle[vertical]);
				minusValSecond = Double.parseDouble(arrAngle[vertical+1]);
				minusValThird= minusValSecond - minusValFirst;
				if(vertical!=0){
					dupNormalVector3D.rotate(getRadian(minusValThird),dupLowerVector3D);
				}
				dupNormalVector3D.setMagnitude(Double.parseDouble(arrRng[vertical])*1000);
				
				for(horizontal =0; horizontal<=circleDiv;horizontal++){
					if(horizontal!=0){
						dupNormalVector3D.rotate(rads, upperVector3D);
						
					}
					surfacePt = ADAPSUtil.constructPoint3d(point.getX()+dupNormalVector3D.getXComponent()/111120, point.getY()+dupNormalVector3D.getYComponent()/111120, point.getZ()+dupNormalVector3D.getZComponent());
//					surfacePt = ADAPSUtil.constructPoint3d(point.getX()+dupNormalVector3D.getXComponent()/111120, point.getY()+dupNormalVector3D.getYComponent()/111120, point.getZ());
	/*
	 * 
	 * 				Changes Done on 03-05-2013 for Display Height
	 * 				
	 */
					if(displayType.equals("Show Height"))
					{
						
						/***********Do not make the Surface point ZAWARE********************/
						//ADAPSUtil.makeZAware(surfacePt);
						obstaclePoint = ADAPSUtil.CheckZCoordinate(point, surfacePt, surface);
		                if(obstaclePoint != null)
		                {
		                	ADAPSUtil.makeZAware(obstaclePoint);
		                    pointCol.addPoint(obstaclePoint, null, null);
		                }
		                else
		                {
		                    pointCol.addPoint(surfacePt, null, null);
		                }
					}
					else
					{
						pointCol.addPoint(surfacePt, null, null);
					}
				}
			
				// updated this code on 19/6/13 commented all the part below
//				if(vertical==arrRng.length-2){
//					
//					pointCol.addPoint(point, null, null);
//					
//				}
				
				ringColl=(IRing) pointCol;
				ringColl.close();
				geoColl.addGeometry(ringColl, null, null);
			
			}
					
			IGeometryCollection geometryColl = new MultiPatch();
			IRing newring = (IRing) geoColl.getGeometry(0);
			newring.close();
			geometryColl.addGeometry(newring, null, null);
			
			
			
			int geometryCount=0;
			IPointCollection pointCollFirstGeometry, pointCollSecondGeometry;
			
			for(geometryCount=0;geometryCount<=geoColl.getGeometryCount()-2;geometryCount++){
				pointCollFirstGeometry = (IPointCollection) geoColl.getGeometry(geometryCount);
				pointCollSecondGeometry= (IPointCollection) geoColl.getGeometry(geometryCount+1);
				
				for(int ringCount=0;ringCount<=circleDiv-1;ringCount++){
					IPointCollection newColl = new Ring();
					newColl.addPoint(pointCollFirstGeometry.getPoint(ringCount),null,null);
					newColl.addPoint(pointCollSecondGeometry.getPoint(ringCount), null, null);
					newColl.addPoint(pointCollSecondGeometry.getPoint(ringCount+1), null, null);
					newColl.addPoint(pointCollFirstGeometry.getPoint(ringCount+1),null,null);
					newring=(IRing) newColl;
					
					//geometryColl.addGeometry(newring, null,null);
					newring.close();
				}//geometryColl.addGeometry(newring, null,null);
			}
			// updated on 19/6/13
			
			for(int i=1;i<=9;i++)
			{newring = (IRing) geoColl.getGeometry(geoColl.getGeometryCount()-i);
			newring.close();
			geometryColl.addGeometry(newring, null, null);
			}
			
			//actual code
//			newring = (IRing) geoColl.getGeometry(geoColl.getGeometryCount()-1);
//			newring.close();
//			geometryColl.addGeometry(newring, null, null);
			IGeometry geometry = (IGeometry) geometryColl;
			ADAPSUtil.makeZAware(geometry);

			IFeatureLayer featureLyr = graphicsContainer3D;
			
			SaveUpdateDB initialiseWorkSpace = SaveUpdateDB.getInstance();
			initialiseWorkSpace.setGdbFilename(ADAPSMain.getFeatureClassName());
			initialiseWorkSpace.initFeatureWorkspace();
				
			
			IFeatureWorkspace pFeatureWorkspace = initialiseWorkSpace.getGDBFeatureWorkspace();// .getGDBWorkspace();
			IWorkspaceEdit pWorkspaceEdit =(IWorkspaceEdit) pFeatureWorkspace;
			pWorkspaceEdit.startEditing(true);
			pWorkspaceEdit.startEditOperation();
			IFeature feature = featureLyr.getFeatureClass().createFeature();
			feature.setShapeByRef(geometry);
			System.out.println(xLat+ "----"+xLong+ "--"+ RdrID);
			feature.setValue(feature.getFields().findField("Latitude"),xLat.toString());
			feature.setValue(feature.getFields().findField("Longitude"), xLong.toString());
			feature.setValue(feature.getFields().findField("Id"), RdrID);
			feature.setValue(feature.getFields().findField("DateofDeployment"), "30/01/2013");
			feature.setValue(feature.getFields().findField("Remarks"), "new layer");
			feature.setValue(feature.getFields().findField("Color"), 3);
			feature.store();
			
			pWorkspaceEdit.stopEditOperation();
			pWorkspaceEdit.stopEditing(true);
			
			
	//		IGlobeDisplayLayers2 globeDisplayLayer = (IGlobeDisplayLayers2) ADAPSMain.getGlobeBean().getGlobe().getGlobeDisplay();
	//		globeDisplayLayer.refreshLayer(graphicsContainer3D);
			
			ILayerEffects layerEffect = (ILayerEffects) graphicsContainer3D;
			short transparency = 50;
			layerEffect.setTransparency(transparency);
			
			IGlobeDisplayLayers2 globeDisplayLayer = (IGlobeDisplayLayers2) ADAPSMain.getGlobeBean().getGlobe().getGlobeDisplay();
			globeDisplayLayer.refreshLayer(graphicsContainer3D);
			
			IColor polylineColor = ADAPSUtil.getColor(255, 0, 0);
			
			//Outline to 3D
			ADAPSUtil.addOutlinetoGraphicsLayer3D(outlineGraphicsContainer3D, geometryColl, polylineColor, esriSimple3DLineStyle.esriS3DLSStrip,1.0);
			
			GroupLayer groupLayer = new GroupLayer();
			groupLayer.setName("RADAR");
			groupLayer.add(symLyr);
			groupLayer.add(graphicsContainer3D);
			groupLayer.add((ILayer) outlineGraphicsContainer3D);
			
			ADAPSMain.getGlobeBean().getGlobe().addLayerType((ILayer)groupLayer, esriGlobeLayerType.esriGlobeLayerTypeUnknown, false);
			ADAPSMain.getGlobeBean().getGlobeDisplay().refreshViewers();
			
			initialiseWorkSpace.ClearWorkspace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
			 
			
		}
			
		private String[] retrieveARHData(String tableName,String attribute) throws AutomationException, IOException
		{
			SaveUpdateDB fetchARHData = SaveUpdateDB.getInstance();
			fetchARHData.setGdbFilename(ADAPSMain.getRadarGeoDBFilename());
			fetchARHData.initWorkspace();
			ICursor ic = fetchARHData.fetchSqlQury(tableName, attribute);
			IRow ir = ic.nextRow();
			int rowCount = 0;
			while(ir != null)
			{
				rowCount++;
				ir = ic.nextRow();
			}
			String data[] = new String[rowCount];
			ICursor ic1 = fetchARHData.fetchSqlQury(tableName, attribute);
			IRow ir1 = ic1.nextRow();
			int i=0;
			while(ir1 !=null)
			{
				data[i] = ir1.getValue(0).toString();
				ir1 = ic1.nextRow();
				i++;
			}
			return data;
		}
	
		private IGraphicsContainer3D getGraphicsLayer() {
			// TODO Auto-generated method stub
			ILayer iLayer;
			boolean chkLyr = false;
			try {
				int layerCount = ADAPSMain.getGlobeBean().getGlobeDisplay().getScene().getLayerCount();
				for(int i=0;i< layerCount;i++){
					iLayer = ADAPSMain.getGlobeBean().getGlobeDisplay().getScene().getLayer(i);
					
				}
			} catch (AutomationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		
		public ILayer displaySymbol(Double xLat, Double xLong,IPoint point) {
			String fileSymbol = System.getProperty("user.dir")+"/radar.bmp";
			System.out.println(fileSymbol);
			ILayer iLyr = null;
			IGraphicsContainer iGlbCnt = null;
			try {
				
				IRgbColor color = new RgbColor();
			    color.setRed(255);
			    color.setGreen(0);
			    color.setBlue(0);
	
			    //create a marker symbol
			    SimpleMarker3DSymbol sym = new SimpleMarker3DSymbol();
				sym.setStyle(esriSimple3DMarkerStyle.esriS3DMSDiamond);
				
				sym.setResolutionQuality(1);
				sym.setColor(color);
				IMarkerSymbol imSym = (IMarkerSymbol)sym;
				imSym.setColor(color);
				imSym.setSize(500);
							
				IMarkerElement mkElem = new MarkerElement();
				mkElem.setSymbol(sym);
				Point objPoint = new Point();
				objPoint.project(ADAPSMain.getGlobeBean().getGlobeDisplay().getScene().getSpatialReference());
				objPoint.putCoords(xLat, xLong);	
				
				IElement mrkIElem = new MarkerElement();
				mrkIElem = (IElement)mkElem;
				mrkIElem.setGeometry(point);
				
				iGlbCnt=new GlobeGraphicsLayer();
				iLyr = (ILayer) iGlbCnt;
				iLyr.setName("Symbol");
				iGlbCnt.addElement(mrkIElem,0);
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return iLyr;
		}
		
		private double getRadian(double x){
			return x*(Math.PI/180);
		}

}
