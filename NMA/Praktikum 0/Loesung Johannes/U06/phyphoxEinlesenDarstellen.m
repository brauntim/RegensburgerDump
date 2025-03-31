%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% Praktikum Computerarithmetik und Rechenverfahren
%
% Martin Weiß
%
% 2019
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%
% csv-Datei einlesen, Zeile 1 überlesen
% M = csvread('Raw Data.csv', 1);
% M = csvread('RawData2.csv', 1);
% M = csvread('RawDataFormattest.csv', 1);

%%
% csvread is not recommended. Use readmatrix instead. For more information, see Compatibility Considerations.
M = readmatrix('Raw Data.csv', 'NumHeaderLines', 1);

% Zugriff auf spalten
t = M(:,1);          % Zeit
a = M(:,2:4);        % Beschleunigung x,y,z
aAbs = M(:,5);       % Absolutbetrag der Beschleunigung

%% plotten
figure(1); 
% clf; % nicht unbedingt nötig
subplot(3,1,1)

ylabel('Beschleunigung a (m/s^2)')
xlabel('Zeit t (s)')
plot(t, a(:,1));
title('Beschleunigung x');

subplot(3,1,2)
ylabel('Beschleunigung a (m/s^2)')
xlabel('Zeit t (s)')
plot(t, a(:,2));
title('Beschleunigung y');

subplot(3,1,3)
ylabel('Beschleunigung a (m/s^2)')
plot(t, a(:,3));
xlabel('Zeit t (s)')
title('Beschleunigung z');

%% 3 Beschleunigungskomponenten in 1 plot
figure(2);
plot(t, a);
legend('a_x', 'a_y', 'a_z')

%% 3 Beschleunigungskomponenten in 1 plot
% Absolutbeschleunigung ist das auch richtig gerechnet?
figure(3);
plot(t, aAbs);
aCheck = sqrt(sum(a.^2, 2));
% plot beibehalten, weiteren plot in gleicher Graphik
hold on;      % plot löscht sonst alte Darstellungen
plot(t, aCheck, 'r.')
grid on 
