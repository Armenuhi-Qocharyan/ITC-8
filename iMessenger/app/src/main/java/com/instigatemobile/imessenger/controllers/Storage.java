package com.instigatemobile.imessenger.controllers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.InputStream;


public class Storage {
    private static Storage storage;
    private FirebaseStorage firebaseStorage;
    private StorageReference storageRef;
    private DataBase DB;

    private Storage() {
        firebaseStorage = FirebaseStorage.getInstance();
        storageRef = firebaseStorage.getReference();
        DB = DataBase.initDataBase();
    }

    public static Storage initStorage() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public void uploadImageToStorage(InputStream stream, final String path, final String imageName, final ProfileCallbackInterface profileCallback) {
        final String dbPath = "images/" + path;

        StorageReference spaceRef = storageRef.child(dbPath);
        UploadTask uploadTask = spaceRef.putStream(stream);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                Uri downloadUrl = taskSnapshot.getDownloadUrl();

                if (imageName.equals("avatar")) {
                    profileCallback.changeImage(dbPath, "avatar");
                    downloadImageFromStorage(dbPath, "avatar", profileCallback);
                } else if (imageName.equals("background")) {
                    profileCallback.changeImage(dbPath, "background");
                    downloadImageFromStorage(dbPath, "background", profileCallback);
                }

            }
        });

    }

    public void downloadImageFromStorage(String path, final String imageName, final ProfileCallbackInterface profileCallback) {
        storageRef.child(path).getBytes(Long.MAX_VALUE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                // Use the bytes to display the image
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                if (imageName.equals("avatar")) {
                    profileCallback.setAvatar(bitmap);
                } else if (imageName.equals("background")) {
                    profileCallback.setBackgroundAvatar(bitmap);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {

                if (imageName.equals("avatar")) {
                    profileCallback.setAvatar(null);
                } else if (imageName.equals("background")) {
                    profileCallback.setBackgroundAvatar(null);
                }
            }
        });
    }
}
