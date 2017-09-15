This is the README file of iBlog project developed by ITC.

CONTENTS
        1. AUTHOR
        2. PREREQUISITES
        3. DIRECTORY STRUCTURE
        4. USAGE
        5. DOCUMENTATION

1. AUTHOR

Nelli Melkonyan
Ruben Ghalayan
Khachik Ghazaryan
Smbat Dallakyan
Liana Andreasyan

Project Maintainer
	Smbat Sargsyan
	Nane Hambardzumyan


2. PREREQUISITES

        - Android >4.0.3 

3. DIRECTORY STRUCTURE

Main directories are:

-activities                  - Project activities go here. 
        -MainActivity
        -ProfileActivity
        -SplashActivity
	-LoginRegisterActivity

-adapters                    - Adapters for our models 
        -AboutUsAdapter
        -CommentAdapter
        -FavoritesAdapter
        -FirebaseRecyclerAdapter.java
        -FollowersAdapter.java
        -ListAdapter.java
        -UserAdapter.java

-fragments                    - all fragments go here
        -AboutUsFragment.java
        - FavoritesFragment.java
        - FavoritesPostsFragment.java
        - FollowersFragment.java
        - ForgotPasswordFragment.java
        - LoginFragment.java
        - PostCommentsFragment.java
        - PostsFragment.java
        - RegisterFragment.java
        - UsersFragment.java
      
-models                       
        - CommentModel.java
        - NotificationData.java
        - PostModel.java
        - PostRequestData.java
        - UserModel.java
