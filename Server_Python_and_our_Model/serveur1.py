import flask
import werkzeug
import cv2
import numpy as np

app = flask.Flask(__name__)

@app.route('/', methods = ['GET', 'POST'])

def handle_request():
    imagefile = flask.request.files['image']
    filename = werkzeug.utils.secure_filename(imagefile.filename)
    
    # Load Yolo
    net = cv2.dnn.readNet("c:/Users/asus/Desktop/Android_test/Projet_android/yolov3.weights", "c:/Users/asus/Desktop/Android_test/Projet_android/yolov3.cfg")
    classes = []
    with open("c:/Users/asus/Desktop/Android_test/Projet_android/coco.names", "r") as f:
        classes = [line.strip() for line in f.readlines()]
        layer_names = net.getLayerNames()
        output_layers = [layer_names[i[0] - 1] for i in net.getUnconnectedOutLayers()]
        colors = np.random.uniform(0, 255, size=(len(classes), 3))
    
    # Loading image
	img = imagefile
    #img = cv2.imread("c:/Users/asus/test.jpg")
    img = cv2.resize(img, None, fx=0.4, fy=0.4)
    height, width, channels = img.shape
    
    # Detecting objects
    blob = cv2.dnn.blobFromImage(img, 0.00392, (416, 416), (0, 0, 0), True, crop=False)
    
    net.setInput(blob)
    outs = net.forward(output_layers)
    filename = "Image non claire"
	
    # Showing informations on the screen
    class_ids = []
    confidences = []
    boxes = []
    for out in outs:
        for detection in out:
            scores = detection[5:]
            class_id = np.argmax(scores)
            confidence = scores[class_id]
            if confidence > 0.5:
                # Object detected
                center_x = int(detection[0] * width)
                center_y = int(detection[1] * height)
                w = int(detection[2] * width)
                h = int(detection[3] * height)
    
                # Rectangle coordinates
                x = int(center_x - w / 2)
                y = int(center_y - h / 2)
    
                boxes.append([x, y, w, h])
                confidences.append(float(confidence))
                class_ids.append(class_id)
                filename = classes[class_id]
    			
        print("\nReceived image File name : " + imagefile.filename)
        return filename
app.run(host="0.0.0.0", port=5000, debug=True)